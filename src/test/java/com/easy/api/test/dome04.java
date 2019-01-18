package com.easy.api.test;

import org.junit.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * @ClassName dome04
 * @Date 2019/1/16 3:22 PM
 * @Author WangXuDong 测试顺序
 **/



public class dome04  {


    /* 注解解释
    *   @BeforeClass 测试类开始前
    *   @Before      测试方法开始前
    *   @Ignore      忽略的方法
    *   @After       测试方法结束后
    *   @AfterClass  测试类结束后
    *
    *    @BeforeClass –> @Before –> @Test –> @After –> @AfterClass

     * */
    @BeforeClass
    public static void beforeClass(){
        System.out.println("测试类开始前");
    }

    @Before
    public void before(){
        System.out.println("测试方法开始前");
    }

    @Ignore
    public void testIgnore() {
        System.out.println("忽略的方法");
    }

    @Test
    public void test() throws Exception {
        System.out.println("测试方法");
    }

    @After
    public void after(){
        System.out.println("测试方法结束后");
    }

    @AfterClass
    public  void afterClass(){
        System.out.println("测试类结束后");
    }

}
