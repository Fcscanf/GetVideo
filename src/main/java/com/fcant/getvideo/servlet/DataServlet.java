package com.fcant.getvideo.servlet;

import com.fcant.getvideo.main.VideosMain;
import com.fcant.getvideo.model.Videos;
import com.fcant.getvideo.util.URLFecter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class DataServlet
 */
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Log logger = LogFactory.getLog(VideosMain.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //初始化一个httpclient
    	try{
        HttpClient client = new DefaultHttpClient();
        //我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
        String url="http://v.qq.com/x/list/news?itype=872&offset=0&sort=5";
        //抓取的数据
        List<Videos> videos=URLFecter.URLParserVideos(client, url);
        
        System.out.println(videos.size());
        //循环输出抓取的数据
        List<Videos> page = new ArrayList<Videos>();
        int i=0;
        for (Videos v:videos) {
        	if(i<=2){
        	page.add(v);
        	}
            logger.info("url:"+v.getUrl()+"\t"+"img:"+v.getImg()+"\t"+"\ttitle"+v.getTitle());
            i++;
        }
        request.setAttribute("list", page);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
        //将抓取的数据插入数据库
       // MYSQLControl.executeInsert(bookdatas);
	}

}
