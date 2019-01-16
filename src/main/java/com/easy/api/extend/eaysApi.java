package com.easy.api.extend;

import com.easy.api.utlis.ClintUtils;
import com.easy.api.utlis.PropertiesUtils;
import org.apache.http.NameValuePair;


import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;



/**
 * @ClassName eaysApi
 * @Date 2019/1/16 2:11 PM
 * @Author WangXuDong
 **/
public class eaysApi {



  public List<NameValuePair> list = new ArrayList<NameValuePair>();

  public  BasicNameValuePair valuePair;

  private String environment="environment.properties";

  PropertiesUtils propertiesUtils = new PropertiesUtils(environment);

  public  static ClintUtils clintUtils = new ClintUtils();

  public String Urlenvironment;

    //读取环境配置
    @BeforeClass
    public void getProperties(){
        //读取前缀
      Urlenvironment = (String) propertiesUtils.getProperty("qa");
    }



}
