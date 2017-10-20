package cn.xhu.web;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import cn.xhu.dto.Exposer;
import cn.xhu.dto.SeckillExecution;
import cn.xhu.dto.SeckillResult;
import cn.xhu.entity.Seckill;
import cn.xhu.exception.RepeatKillException;
import cn.xhu.exception.SeckillCloseException;
import cn.xhu.service.SeckillService;

@Controller
@RequestMapping("/seckill")//url:/模块/（细分....）   /seckill/list
public class seckillController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillService seckillService;
	/**
	 *  获取商品列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model){
		//list.jsp+model=ModelAndView
		List<Seckill> seckills= seckillService.getSeckillList();
		model.addAttribute("seckills", seckills);
		return "list";
	}
	/**
	 * 获取单个商品详细信息
	 * @param seckillId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("seckillId") Long seckillId,Model model){
		if(seckillId==null){
			return "redirect:/seckill/list";
		}
		Seckill seckill = seckillService.getById(seckillId);
		if(seckill==null){
			return "forward:/seckill/list";
		}
		
		model.addAttribute("seckill",seckill);
		return "detail";
	}
	/**
	 * 获得秒杀的接口情况，使用json格式返回
	 * @param seckillId
	 * @return
	 */
	@RequestMapping(value="/{seckillId}/exposer",
					method=RequestMethod.POST,
					produces={"application/json;chaset=utf-8"})
	@ResponseBody
	public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId){
		SeckillResult<Exposer> result;		
		try{
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			result = new SeckillResult<Exposer>(true,exposer);
		}catch(Exception e){
			logger.error(e.getMessage());
			result = new SeckillResult<Exposer>(false,e.getMessage());
		}
		return result;
	}
	
	/**
	 * 执行秒杀操作
	 * @param seckillId
	 * @param md5
	 * @param userPhone
	 * @return
	 */
	@RequestMapping(value="/{seckillId}/{md5}/execute",
					method=RequestMethod.POST,
					produces={"application/json;chaset=utf-8"})
	@ResponseBody
	public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
												   @PathVariable("md5") String md5,
												   @CookieValue(value="userPhone",required=false) Long userPhone){
		SeckillResult<SeckillExecution> result;
		try{
			SeckillExecution execution = seckillService.executeSeckill(seckillId, userPhone, md5);
			result = new SeckillResult<SeckillExecution>(true,execution);		
		}catch(SeckillCloseException sc){
			result=new SeckillResult<SeckillExecution>(false,"秒杀关闭");
		}catch(RepeatKillException re){
			result=new SeckillResult<SeckillExecution>(false,"重复秒杀");
		}catch(Exception e){
			result=new SeckillResult<SeckillExecution>(false,e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/time/now",method=RequestMethod.GET)
	@ResponseBody
	public long nowTime(){
		Date date = new Date();
		return date.getTime();
	}
}
