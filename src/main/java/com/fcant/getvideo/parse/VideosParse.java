package com.fcant.getvideo.parse;


import com.fcant.getvideo.model.Videos;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
 
/*
 * author dingjun
 * 用于将上面传下来的html解析，获取我们需要的内容
 * 解析方式，采用Jsoup解析，有不明白Jsoup的可以上网搜索API文档
 * Jsoup是一款很简单的html解析器
 */
public class VideosParse {
    public static List<Videos> getData (String html) throws Exception{
        //获取的数据，存放在集合中
        List<Videos> data = new ArrayList<Videos>();
        //采用Jsoup解析
        Document doc = Jsoup.parse(html);
        //获取html标签中的内容
        Elements elements=doc.select("div[class=mod_figures mod_figure_h _quickopen]").select("ul[class=figures_list]").select("li[class=list_item]");
       int i=1;
       System.out.println("begin get ele");
        for (Element ele:elements) {
            
          String url=ele.select("a").attr("href");
          String imgtime1=ele.select("span[class=figure_info_right]").text();
            String imgtime2=imgtime1+" "+ele.select("span[class=figure_info_left]").text();
            System.out.println("time"+imgtime2);
                 String title= ele.select("img").attr("alt");
                 String imgs= ele.select("img").attr("r-lazyload");
            //创建一个对象，这里可以看出，使用Model的优势，直接进行封装
                 Videos videos=new Videos();
                 videos.setUrl(url);
                 videos.setImg(imgtime2);
                 videos.setTitle(title);
                 videos.setImgs(imgs);
            //对象的值
            
            //将每一个对象的值，保存到List集合中
            data.add(videos);
        }
        //返回数据
        return data;
    }
}