package com.easy.api.utlis;

import java.io.*;
import java.util.Properties;

/**
 * @ClassName PropertiesUtils
 * @Date 2018/11/2 1:40 PM
 * @Author WangXuDong
 *
 *
 *
 **/


//读取配置文件类

public class PropertiesUtils {
    private String filePath;

    public PropertiesUtils(String fileName) {
        super();
       this.filePath = this.getClass().getClassLoader().getResource(fileName).getPath();
    }

    /**
     * 获取key对应的值
     *
     * @param key
     * @return
     */
    public Object getProperty(String key) {
        Properties pro = new Properties();

        FileInputStream in = null;
        try {
            in = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pro.get(key);
    }






    public static  void main(String[] args) {
        //String filePath = PropertiesUtils.class.getResource("").getPath() + "\\a.properties";


        PropertiesUtils property = new PropertiesUtils("consequence.properties");

         System.out.print( property.getProperty("1"));



    }

}
