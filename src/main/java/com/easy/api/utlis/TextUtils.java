package com.easy.api.utlis;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @ClassName TestUtils  写入类
 * @Date 2018/1/23 11:02 AM
 * @Author WangXuDong
 **/
public class TextUtils {

    public String filePath;


    public  void sendText(String phone,String name,String randomID,int Age,String Birthday,String Gender,String provinceByCard,String fileName) {


        TurnUtils turnUtils = new TurnUtils();

        try {
            this.filePath = this.getClass().getClassLoader().getResource(fileName).getPath();
            File writename = new File(filePath); // 相对路径，如果没有则要建立一个新的output。txt文件
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(
            new FileOutputStream(writename, true)));

            pw.println(new Date().toString()+"\r\n");
            pw.println("手机号 :"+phone+"\r\n");// \r\n即为换行
            pw.println("NameUtis :"+name+"\r\n");
            pw.println("身份证号 :"+randomID+"\r\n");
            pw.println("年龄 :"+Age+"\r\n");
            pw.println("生日 :"+Birthday+"\r\n");
            pw.println("性别 :"+Gender+"\r\n");
            pw.println("省份 :"+provinceByCard+"\r\n");
            pw.println("===================================\r\n");
            pw.flush(); // 把缓存区内容压入文件
            pw.close(); // 最后记得关闭文件


       }catch (Exception e) {
           e.printStackTrace();
       }


    }


}
