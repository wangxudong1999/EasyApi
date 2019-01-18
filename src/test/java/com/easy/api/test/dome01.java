package com.easy.api.test;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.easy.api.extend.eaysApi;

import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @ClassName dome01
 * @Date 2019/1/16 2:33 PM
 * @Author WangXuDong
 **/
public class dome01 extends eaysApi {

    //log
    private  final Logger logger = LoggerFactory.getLogger(dome01.class);

    //url
    private  String url = "/passport/user/getUserinfoByCellRole";

    //请求方法
    private  String method= "post";

    @Test
    public void checkUid () throws JSONException, IOException {

        //添加数据
        list.add(new BasicNameValuePair("q", "{\"role\":1,\"cell\":\"17640592259\"}"));

        //请求
        String value = clintUtils.httpResponse(list, url, method,Urlenvironment);

        //log打印
        logger.info(value);

        JSONObject jsonObj = JSONObject.parseObject(value);

        //断言
        Assert.assertEquals( jsonObj.getString("uid"), "299067474756646");

    }




}
