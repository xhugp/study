package cn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static List<String> list ;
	static{
		list = new ArrayList<String>();
		list.add("ajax pop");
		list.add("ajax详解");
		list.add("black");
		list.add("bananer");
		list.add("cup");
		
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String content = request.getParameter("search_text");
		List<String> moreContents = new ArrayList<String>();
		for (String string : list) {
			if(string.contains(content)){
				moreContents.add(string);
			}
		}
		//转化为json格式输出
		//JSONArray.fromObject(moreContents);
		response.getWriter().write(JSONArray.fromObject(moreContents).toString());
	}


}
