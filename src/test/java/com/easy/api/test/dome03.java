package com.easy.api.test;

import com.alibaba.fastjson.JSONException;
import com.easy.api.bean.AllBean;
import com.easy.api.extend.eaysApi;
import com.easy.api.utlis.JdbcUtil;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @ClassName dome02
 * @Date 2019/1/16 3:22 PM
 * @Author WangXuDong
 **/
public class dome03 extends eaysApi {


    JdbcUtil jdbcUtil = new JdbcUtil();


    //增删改更新数据
    @Test()
    public void update () throws JSONException, IOException {

        String update ="update user_info set age=? where  phone='17640592255'";
        jdbcUtil.getUtils(update, new Object[]{"28"});


    }



    // 查询一条记录, 返回对应的对象
    @Test()
    public void get() throws JSONException, IOException {


        String getSql = "select * from user_info where phone = '17640592255'";

        AllBean allBean = jdbcUtil.excuteQuery(AllBean.class, getSql);


        System.out.print(allBean);

    }


}
