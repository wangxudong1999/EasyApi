package com.easy.api.test;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.easy.api.extend.eaysApi;
import com.easy.api.utlis.PropertiesUtils;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @ClassName dome02
 * @Date 2019/1/16 3:22 PM
 * @Author WangXuDong
 **/
public class dome02 extends eaysApi {

    private  final Logger logger = LoggerFactory.getLogger(dome01.class);

    private  String url = "/passport/user/getUserinfoByCellRole";

    private  String method= "post";

    @Test()
    public void checkUid () throws JSONException, IOException {

        PropertiesUtils propertiesUtils = new PropertiesUtils("value.properties");

        String  q = (String) propertiesUtils.getProperty("q");

        list.add(new BasicNameValuePair("q", q));

        String value = clintUtils.httpResponse(list, url, method,Urlenvironment);

        logger.info(value);

        JSONObject jsonObj = JSONObject.parseObject(value);

        Assert.assertEquals(jsonObj.getString("uid"), "299067474756646");

    }


}
