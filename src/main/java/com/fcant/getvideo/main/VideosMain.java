package com.fcant.getvideo.main;

import com.fcant.getvideo.model.Videos;
import com.fcant.getvideo.util.URLFecter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.List;
 
 
 
 
public class VideosMain {
    //log4j的是使用，不会的请看之前写的文章
    static final Log logger = LogFactory.getLog(VideosMain.class);
    public static void main(String[] args) throws Exception {
        //初始化一个httpclient
    	try{
        HttpClient client = new DefaultHttpClient();
        //我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
        String url="http://v.qq.com/x/list/news?offset=0&itype=872";
        //抓取的数据
        List<Videos> videos=URLFecter.URLParserVideos(client, url);
        System.out.println(videos.size());
        //循环输出抓取的数据
        for (Videos v:videos) {
            logger.info("url:"+v.getUrl()+"\t"+"img:"+v.getImg()+"\t"+"\ttitle"+v.getTitle());
        }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        //将抓取的数据插入数据库
       // MYSQLControl.executeInsert(bookdatas);
    }
}