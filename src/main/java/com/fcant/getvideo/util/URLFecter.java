package com.fcant.getvideo.util;

import com.fcant.getvideo.model.Videos;
import com.fcant.getvideo.parse.VideosParse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

 

public class URLFecter {
	 
	public static List<Videos> URLParserVideos (HttpClient client, String url) throws Exception {
        //用来接收解析的数据
        List<Videos> data = new ArrayList<Videos>();
        //获取网站响应的html，这里调用了HTTPUtils类
        HttpResponse response = HTTPUtils.getRawHtml(client, url);
        //获取响应状态码
        int StatusCode = response.getStatusLine().getStatusCode();
        //如果状态响应码为200，则获取html实体内容或者json文件
        if(StatusCode == 200){
            String entity = EntityUtils.toString (response.getEntity(),"utf-8");    
            data = VideosParse.getData(entity);
            EntityUtils.consume(response.getEntity());
        }else {
            //否则，消耗掉实体
            EntityUtils.consume(response.getEntity());
        }
        return data;
    }
}
