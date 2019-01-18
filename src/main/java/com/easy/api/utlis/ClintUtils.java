package com.easy.api.utlis;



import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName ClintUtils
 * @Date 2018/11/2 2:15 PM
 * @Author WangXuDong
 **/


//请求类
public class ClintUtils {

    JSONObject jsonObject = new JSONObject();


    //返回response  默认发git请求
    public  String httpResponse(List<NameValuePair> list, String url, String postAndget,String environment) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        //转为小写
        String postAndgets = postAndget.toLowerCase();



        if (postAndgets.equals("post")) {
            HttpPost httpPost = new HttpPost(environment+url);
            UrlEncodedFormEntity uefEntity =   new UrlEncodedFormEntity(list,"UTF-8");
            httpPost.setEntity(uefEntity);
            //运行
            CloseableHttpResponse httpResponse =  httpClient.execute(httpPost);
            //取参数
            HttpEntity entity = httpResponse.getEntity();
            //转型
            String ResponseValue = EntityUtils.toString(entity);
            //httpClient.close();
            return ResponseValue;

        }else {
            //转换请求参数
            String strValue = EntityUtils.toString(new UrlEncodedFormEntity(list, Consts.UTF_8));
            //拼接请求
            HttpGet httpGet = new HttpGet(environment+url+"?"+strValue);
            //执行请求
            CloseableHttpResponse httpResponse =  httpClient.execute(httpGet);
            //获得请求体
            HttpEntity entity = httpResponse.getEntity();
           // httpClient.close();
            String ResponseValue = EntityUtils.toString(entity);

            return ResponseValue;
        }

    }

}
