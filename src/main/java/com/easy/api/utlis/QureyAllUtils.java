package com.easy.api.utlis;

import java.io.IOException;

/**
 * @ClassName QureyUser
 * @Date 2018/12/27 12:33 PM
 * @Author WangXuDong
 **/
public class QureyAllUtils {

    //根据手机号获取 token  mid uid 匹配身份证号
    public String getAll(String phone,int minAge, int maxAge,String fileName)  throws IOException{





        //生成身份证号
        NoIdUtils noIdUtils = new NoIdUtils();
        String randomID = noIdUtils.getRandomID(minAge,maxAge);
        //年龄
        int Age = noIdUtils.getAgeByIdCard(randomID);
        //生日
        String Birthday = noIdUtils.getBirthByIdCard(randomID);
        //性别 M-男，F-女
        String Gender = noIdUtils.getGenderByIdCard(randomID);
        if(Gender.equals("M")){
            Gender= "男";
        }else {
            Gender= "女";
        }
        //省份
        String provinceByCard = noIdUtils.getProvinceByIdCard(randomID);

        String name = noIdUtils.getName();

        //写入文件
        TextUtils textUtils = new TextUtils();

        textUtils.sendText(phone,name ,randomID , Age, Birthday, Gender,provinceByCard, fileName);


        String All ="手机号 :"+phone+"\r\n"+
                    "Name :"+name+"\r\n"+
                    "身份证号 :"+randomID+"\r\n"+
                    "年龄 :"+Age+"\r\n"+
                    "生日 :"+Birthday+"\r\n"+
                    "性别 :"+Gender+"\r\n"+
                    "省份 :"+provinceByCard+"\r\n";


        return All;
    }



    public static void main(String[] args) throws IOException {
        QureyAllUtils qureyUser = new QureyAllUtils();
        String tokenAndMidAndUid = qureyUser.getAll("17640592258",20,21,"test.txt");
        System.err.print(tokenAndMidAndUid);

    }




}
