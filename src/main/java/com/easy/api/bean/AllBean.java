package com.easy.api.bean;

/**
 * @ClassName AllBean
 * @Date 2019/1/2 5:24 PM
 * @Author WangXuDong
 **/
public class AllBean {
    /*
    *
        String All ="手机号 :"+phone+"\r\n"+
                    "role :"+role+"\r\n"+
                    "mid :"+mid+"\r\n"+
                    "uid :"+uid+"\r\n"+
                    "token :"+token+"\r\n"+
                    "Name :"+name+"\r\n"+
                    "身份证号 :"+randomID+"\r\n"+
                    "年龄 :"+Age+"\r\n"+
                    "生日 :"+Birthday+"\r\n"+
                    "性别 :"+Gender+"\r\n"+
                    "省份 :"+provinceByCard+"\r\n";
                    int minAge, int maxAge
    *
    *
    *
    * */

    public Long id ;
    public String role;
    public String phone;
    public String mid;
    public String uid;
    public String name;
    public String randomID;
    public int Age;
    public String Birthday;
    public String provinceByCard;
    public int minAge;
    public int maxAge;
    public String Gender;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRandomID() {
        return randomID;
    }

    public void setRandomID(String randomID) {
        this.randomID = randomID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getProvinceByCard() {
        return provinceByCard;
    }

    public void setProvinceByCard(String provinceByCard) {
        this.provinceByCard = provinceByCard;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }


    @Override
    public String toString() {
        return "AllBean{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", phone='" + phone + '\'' +
                ", mid='" + mid + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", randomID='" + randomID + '\'' +
                ", Age=" + Age +
                ", Birthday='" + Birthday + '\'' +
                ", provinceByCard='" + provinceByCard + '\'' +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
