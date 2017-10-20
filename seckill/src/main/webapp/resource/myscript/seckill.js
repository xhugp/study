//存放交互的js代码
//javascript模块化

var seckill = {
		//封装秒杀相关的ajax的url
		URL : {
			nowTime : function(){
				return "/seckill/seckill/time/now";
			},
			exposer : function(seckillId){
				return "/seckill/seckill/"+seckillId+"/exposer";
			},
			executeUrl : function(seckillId,md5){
				return "/seckill/seckill/"+seckillId+"/"+md5+"/execute";
			}
		},
		validate : function(phone){
			if(phone && phone.length==11 && !isNaN(phone)){
				return true;
			}else{
				return false;
			}
		},
		startKill : function(seckillId,node){
			//处理秒杀逻辑
				//显示秒杀接口
			node.hide().html("<button class='btn btn-primary btn-lg' id='killbtn'>开始秒杀</button>");
			$.post(seckill.URL.exposer(seckillId),{},function(result){
				if(result && result['success']){
					//请求成功
					var exposer = result['data'];
					if(exposer['exposed']){
						// 该商品开启了秒杀
						 var md5 = exposer['md5'];
						//执行秒杀
						 var seckillUrl = seckill.URL.executeUrl(seckillId, md5);
						 $('#killbtn').one('click',function(){
							 //禁止重复请求
							 $(this).addClass("disabled");
							 $.post(seckillUrl,{},function(exeresult){
								 if(exeresult && exeresult['success']){
									 var execution = exeresult['data'];
									 var stateInfo = execution['stateInfo'];
									 node.html("<span class='label label-success'>"+stateInfo+"</span>");
								 }else{
									 var message = exeresult['errorMessage'];
									 node.html("<span class='label label-success'>"+message+"</span>");
								 }
							 });
						 });
						node.show(); 
					}else{
						//该商品未开启秒杀
						var now = exposer['now'];
						var start = exposer['start'];
						var end = exposer['end'];
						seckill.checkKill(now, start, end, seckillId);
					}
				}else{
					//请求失败
				}
			});
		},
		checkKill : function(nowTime,startTime,endTime,seckillId){
			var seckillbox = $('#seckill-box');
			if(nowTime > endTime){
				seckillbox.html("秒杀已经结束！");
			}else if(nowTime < startTime){
				var killTime = new Date(Number(startTime)+1000);
				//计时器
				seckillbox.countdown(killTime,function(event){
					var format = event.strftime("秒杀倒计时：%D天  %H时  %M分  %S秒");
					seckillbox.html(format);
				}).on('finish.countdown',function(){
					// 倒计时结束执行的操作,暴露秒杀接口,控制显示逻辑，执行秒杀
					 seckill.startKill(seckillId,seckillbox);
				});
			}else{
				//秒杀开始
				seckill.startKill(seckillId,seckillbox);
			}
		},		
		detail : {
			//详情页展示
			init : function(params){
				//手机验证和登录，计时交互
				//规划交互流程
				var killPhone = $.cookie('userPhone');
				if(!seckill.validate(killPhone)){
					//绑定phone
					var killmodel = $('#killmodel');
					killmodel.modal({
						show : true,
						backdrop : 'static',//禁止位置关闭
						keyboard:false,	
					});
					$('#killPhoneBtn').click(function(){
						var inputPhone = $('#killPhoneKey').val();
						if(seckill.validate(inputPhone)){
							//写入cookie
							$.cookie('userPhone',inputPhone,{expires:7,path:'/seckill'});
							//刷新页面
							window.location.reload();
						}else{
							$('#killPhoneMessage').hide().html('<lable class="label label-danger">手机号错误</lable>').show(300);
							
						}
						
					});
					
				}
				//登录之后
				var startTime = params['startTime'];
				var endTime = params['endTime'];
				var seckillId = params['seckillId'];
				//得到当前服务器时间
				$.get(seckill.URL.nowTime(),{},function(result){	
					if(result){
						var nowTime = result;
						//时间判断，判断秒杀开启情况
						seckill.checkKill(nowTime, startTime, endTime, seckillId);
					}else{
						console.log("result="+result);
					}
					
				});
							
			}			
		}
		
}