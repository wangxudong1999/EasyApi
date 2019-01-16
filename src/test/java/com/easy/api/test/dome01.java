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

    private  final Logger logger = LoggerFactory.getLogger(dome01.class);

    private  String url = "/passport/user/getUserinfoByCellRole";

    private  String method= "post";

    @Test
    public void checkUid () throws JSONException, IOException {

        list.add(new BasicNameValuePair("q", "{\"role\":1,\"cell\":\"17640592259\"}"));

        String value = clintUtils.httpResponse(list, url, method,Urlenvironment);

        logger.info(value);

        JSONObject jsonObj = JSONObject.parseObject(value);

        Assert.assertEquals( jsonObj.getString("uid"), "299067474756646");

    }




}
