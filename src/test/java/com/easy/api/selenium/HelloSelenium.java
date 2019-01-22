package com.easy.api.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @ClassName HelloSelenium
 * @Date 2019/1/21 4:32 PM
 * @Author WangXuDong
 **/
public class HelloSelenium {


   public String filePath;


    public String getPath() {

        filePath = this.getClass().getClassLoader().getResource("chromedriver").getPath();

        return filePath;

    }



    @Test
    public void main() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",this.getPath());

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.baidu.com/");

//        String title = driver.getTitle();
//        System.out.println(title);

//        System.out.println("改变浏览器窗口大小");
//        Borwser(driver);

//       System.out.println("浏览器前进后退");
//       BrowserGo(driver);

//         System.out.println("浏览器元素操作");
//         BrowserOperation(driver);

//        System.out.println("模拟鼠标操作");
//        MouseOperation(driver);

//        System.out.println("模拟键盘操作");
//        KeyBoardOperation(driver);

//        System.out.println("获取断言信息");
//        Assert(driver);

//        System.out.println("设置元素等待");
//        ElementWait(driver);

//        System.out.println("定位一组元素");
//        ElementsPositioning(driver);

 //       System.out.println("多表单切换");
 //       SwitchTable(driver);

 //       System.out.println("多窗口切换");
 //       WindowsSwitch(driver);

 //       System.out.println("下拉框选择");
 //      SelectWindow(driver);

 //      System.out.println("警告框处理");
 //       AlertDemo(driver);

//        System.out.println("文件上传");
//        FileUpload(driver);

//        System.out.println("浏览器Cookie操作");
//        BorwserCookie(driver);

//          System.out.println("执行JavaScript代码");
//          JavaScript(driver);

//        System.out.println("获取窗口截图");
//        ScreenShot(driver);

    }


    //改变窗口大小
    private static void Borwser(WebDriver driver) throws InterruptedException {

        WebDriver driver1;
        driver1 = driver;

        //最大化窗口
        driver1.manage().window().maximize();
        //时间等待 毫秒
        Thread.sleep(2000);

//        driver1.get("https://m.baidu.cn");
        //设置宽高
        driver1.manage().window().setSize(new Dimension(1200,720));
        //等待
        Thread.sleep(2000);
        //退出驱动并关闭所有关联的窗口。
        driver1.quit();

    }


    //前进后退
    private static void BrowserGo(WebDriver driver) throws InterruptedException{

        WebDriver driver2;
        driver2 = driver;

        //看看链接地址
        System.out.printf("now accesss %s \n", driver.getCurrentUrl());
        Thread.sleep(2000);

        //点击新闻链接
        driver2.findElement(By.linkText("新闻")).click();
        System.out.printf("now accesss %s \n", driver.getCurrentUrl());
        Thread.sleep(1000);

        //试试浏览器后退
        driver2.navigate().back();
        System.out.printf("back to %s \n", driver2.getCurrentUrl());
        Thread.sleep(1000);

        //试试浏览器往前
        driver2.navigate().forward();
        System.out.printf("forward to %s \n", driver2.getCurrentUrl());
        Thread.sleep(1000);

        //试试浏览器刷新
        driver2.navigate().refresh();
        System.out.printf("refresh broswer", driver2.getCurrentUrl());
        Thread.sleep(1000);

        driver2.quit();

    }


    //浏览器元素操作
    private static void BrowserOperation(WebDriver driver) throws InterruptedException{

        WebDriver driver3;
        driver3 = driver;

        WebElement search_text = driver3.findElement(By.id("kw"));
        WebElement search_button = driver3.findElement(By.id("su"));

        // clear() 清除文本 | sendKeys(*value) 模拟按键输入
        search_text.sendKeys("试一下输入");
        Thread.sleep(1000);
        search_text.clear();
        Thread.sleep(1000);
        search_text.sendKeys("Selenium");
        Thread.sleep(1000);
        search_button.click();
        Thread.sleep(1000);
        //sendKeys()方法模拟键盘向输入框里输入内容。我们还可以用它发送键盘按键，甚至用它来指定上传的文件。

        driver3.navigate().back();
        Thread.sleep(1000);

        //搜索到内容以后我回到百度首页，这时候要重新定位元素，不然会报错
        WebElement search_text2 = driver3.findElement(By.id("kw"));
        WebElement search_button2 = driver3.findElement(By.id("su"));

        search_text2.sendKeys("Java");
        search_text2.submit();
        Thread.sleep(1000);
        search_text2.submit();
        Thread.sleep(1000);
        //submit()方法用于提交表单。例如，在搜索框输入关键字之后的“回车” 操作，就可以通过 submit()方法模拟.

        //getSize()
        //getText()
        //getAttribute(name) 获取属性值
        //isDisplayed() 设置元素是否用户可见
        System.out.println("输入框尺寸：" + search_text2.getSize());
        System.out.println("提交按钮尺寸：" + search_button2.getSize());
        System.out.println("提交按钮文本：" + search_button2.getText());
        System.out.println("输入框id：" + search_text2.getAttribute("id") +
                "     输入框Type：" + search_text2.getAttribute("Type"));
        System.out.println("输入框是否可见：" + search_text2.isDisplayed());

        driver3.quit();

    }


    //鼠标操作
    /**
     * 在WebDriver中，这些关于鼠标操作的方法封装在ActionChains类中：
     * ⬇️⬇⬇️
     * contextClick() 右击
     * clickAndHold() 鼠标点击并控制
     * doubleClick() 双击
     * dragAndDrop() 拖动
     * release() 释放鼠标
     * perform() 执行所有Actions中存储的行为,可以理解成是对整个操作的提交动作
     */
    private static void MouseOperation(WebDriver driver) throws InterruptedException{

        WebDriver driver4;
        driver4 = driver;

        //找到百度首页设置按钮，并悬停在按钮上
        WebElement search_setting = driver4.findElement(By.linkText("设置"));
        Actions action = new Actions(driver4);
        action.clickAndHold(search_setting).perform();
        Thread.sleep(3000);

//        //鼠标右键点击指定元素
//        action.contextClick(driver4.findElement(By.id("kw"))).perform();
//        action.click(driver4.findElement(By.id("kw"))).perform();
//        Thread.sleep(2000);

        //鼠标双击指定的元素
        action.doubleClick(driver4.findElement(By.id("su"))).perform();
        Thread.sleep(2000);

        //鼠标拖拽动作，将 search_setting 元素拖放到 search_text 元素的位置
        WebElement search_text = driver4.findElement(By.id("kw"));
        WebElement search_setting2 = driver4.findElement(By.linkText("设置"));
        action.dragAndDrop(search_setting2, search_text).perform();
        Thread.sleep(2000);

        //释放鼠标
        action.release().perform();

        driver4.quit();

        //PS：这里我发现 search_setting 被操作以后如果我在后面的 dragAndDrop 中直接
        //    使用 search_setting 会报错，但是我重新建立一个对象就不会报错 -..-
    }


    //键盘操作
    /**
     * 可以模拟键盘按键
     * 以及组合键,例如 Ctrl+A、 Ctrl+C 等
     * 键盘操作都放在 org.openqa.selenium.Keys 里
     * ⬇️⬇⬇️
     * (Keys.BACK_SPACE) 回格键
     * (Keys.SPACE) 空格键(Space)
     * (Keys.TAB) 制表键(Tab)
     * (Keys.ESCAPE) 回退键（Esc）
     * (Keys.ENTER) 回车键（Enter）
     * (Keys.F1) 键盘 F1
     * ...
     * (Keys.F12) 键盘 F12
     */
    private static void KeyBoardOperation(WebDriver driver) throws InterruptedException{

        WebDriver driver5;
        driver5 = driver;

        WebElement input = driver5.findElement(By.id("kw"));

        //输入下准备数据
        input.sendKeys("Seleniumm");
        Thread.sleep(2000);

        //按下删除键,删除一个 "m"
        input.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);

        //输入空格键
        input.sendKeys(Keys.SPACE);
        input.sendKeys(" + Java");
        Thread.sleep(2000);

        //模拟 Ctrl + a ,全选
        input.sendKeys(Keys.CONTROL, "a");
        Thread.sleep(2000);

        //模拟 Ctrl + x ,剪切
        input.sendKeys(Keys.CONTROL, "x");
        Thread.sleep(2000);

        //模拟 Ctrl + v ,粘贴
        input.sendKeys(Keys.CONTROL, "v");
        Thread.sleep(2000);

        //模拟回车键
        input.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        driver5.quit();
    }


    //获取页面元素
    private static void Assert(WebDriver driver) throws InterruptedException{

        WebDriver driver6;
        driver6 = driver;

        //获取当前的 title 和 url
        System.out.printf("title of current page is %s\n", driver6.getTitle());
        System.out.printf("url of current page is %s\n", driver6.getCurrentUrl());

        //百度搜索
        WebElement search = driver6.findElement(By.id("kw"));
        search.sendKeys("Selenium");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        System.out.println("======== After search ========");

        //获取当前的 title 和 url 看看
        System.out.printf("title of current page is %s\n", driver6.getTitle());
        System.out.printf("url of current page is %s\n", driver6.getCurrentUrl());
        Thread.sleep(2000);

        //获取第一条搜索结果的标题
        WebElement result = driver6.findElement(By.xpath("//*[@id=\"1\"]/h3/a"));
        System.out.println(result.getText());
        Thread.sleep(2000);

        driver6.quit();
    }


    //设置页面元素等待
    private static void ElementWait(WebDriver driver) throws InterruptedException{

        WebDriver driver7;
        driver7 = driver;

        //显示等待，针对某个元素
        /**
         * WebDriverWait(driver, 10, 1)
         * driver： 浏览器驱动。 10： 最长超时时间， 默认以秒为单位。 1： 检测的的间隔（步长） 时间， 默认为 0.5s
         */
        WebDriverWait wait = new WebDriverWait(driver7, 10,1);



        driver7.findElement(By.id("su")).click();
        Thread.sleep(2000);

//        driver7.quit();

        //隐式等待
        /**
         * WebDriver提供的几种方法
         * 1. implicitlyWait (识别对象时的超时时间,过了这个时间如果对象还没找到的话就会抛出NoSuchElement异常)
         * 2. setScriptTimeout (异步脚本的超时时间,WebDriver可以异步执行脚本，这个是设置异步执行脚本脚本返回结果的超时时间)
         * 3. pageLoadTimeout (页面加载时的超时时间,因为WebDriver会等页面加载完毕再进行后面的操作,所以如果页面超过设置时间依然没有加载完成,那么WebDriver就会抛出异常)
         */
        //页面加载超时时间设置为 5s
        driver7.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver7.get("https://www.baidu.com/");

        //每一个隐式等待都只对下一个对应的 driver 操作有效
        driver7.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver7.get("https://www.google.com");

        //定位对象给定 3s 的时间,如果 3s 内没有定位到则抛出异常
        driver7.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver7.findElement(By.id("kw")).sendKeys("selenium");
        Thread.sleep(2000);

        //异步脚本的超时时间设置为 3s
        driver7.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

        driver7.quit();
    }


    //定位『一组』元素
    /**
     * 定位一组元素其实就类似于定位元素,只不过用的方法是 findElements ,多一个 "s"
     */
    private static void ElementsPositioning(WebDriver driver) throws InterruptedException {

        WebDriver driver8;
        driver8 = driver;

        WebElement search_text = driver8.findElement(By.id("kw"));
        search_text.sendKeys("Selenium");
        search_text.submit();
        Thread.sleep(2000);

        /**
         * 通过 xpath ,我们找到匹配到的第一页搜索结果 循环打印
         * 这里打印的是第一页搜索的搜索结果，因为搜索结果展示都可以通过 //div/div/h3 定位到
         */
        List<WebElement> search_result = driver8.findElements(By.xpath("//div/div/h3"));

        //打印元素的个数
        System.out.println(search_result.size());

        //循环打印搜索结果的标题
        for (WebElement result : search_result){
            System.out.println(result.getText());
        }

        System.out.println("-------- *..* --------");

        //打印第 n 结果的标题
        WebElement text = search_result.get(search_result.size() - 10);
        System.out.println(text.getText());

        driver8.quit();
    }


    //多表单切换
    /**
     * WebDriver 只能在一个页面上对元素识别与定位,但是对于 frame/iframe 表单内嵌页面上的元素无法直接定位
     * 这时就需要通过 switchTo().frame()方法将当前定 位的主体切换为 frame/iframe 表单的内嵌页面中
     * iframe 基本已经被h5淘汰,不过我们还是要了解一下,以126邮箱登录为例
     */
    private static void SwitchTable(WebDriver driver) {

        WebDriver driver9;
        driver9 = driver;

        driver9.get("http://www.126.com");

        //这里等待 5s ,因为 iframe 的创建比其它包括 scripts 和 css 的 DOM 元素的创建要慢 1-2 个数量级
        driver9.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement frame = driver9.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
        driver9.switchTo().frame(frame);    //switchTo 还可以切换到弹出框等

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("username");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.id("dologin")).click();

        //切换回默认页面
        driver.switchTo().defaultContent();

    }


    //多窗口切换
    /**
     * getWindowHandle()： 获得当前窗口句柄
     * getWindowHandles()： 返回的所有窗口的句柄到当前会话
     * switchTo().window()： 用于切换到相应的窗口,与上面的switchTo().frame()类似
     */
    private static void WindowsSwitch(WebDriver driver) throws InterruptedException {

        WebDriver driver10;
        driver10 = driver;

        //获得当前窗口句柄
        String search_handle = driver10.getWindowHandle();

        //打开百度注册窗口
        driver10.findElement(By.linkText("登录")).click();
        Thread.sleep(2000);
        driver10.findElement(By.linkText("立即注册")).click();
        Thread.sleep(2000);

        //获得当前窗口的句柄
        String search_handle_register = driver10.getWindowHandle();

        //获取所有窗口句柄
        Set<String> handles = driver10.getWindowHandles();

        //判断是否为注册窗口， 并操作注册窗口上的元素
        for (String handle : handles){
            if (handle.equals(search_handle_register) == false){
                driver10.switchTo().window(handle);
                System.out.println("现在在注册页面");
                Thread.sleep(2000);
                driver10.findElement(By.name("userName")).clear();
                driver.findElement(By.name("userName")).sendKeys("用户名");
                driver.findElement(By.name("phone")).clear();
                driver.findElement(By.name("phone")).sendKeys("电话号码");
                //......
                Thread.sleep(2000);
                //关闭当前窗口
                driver10.close();
            }
        }
        Thread.sleep(2000);

        driver10.quit();
    }


    //下拉框选择
    /**
     * WebDriver提供了 Select 类来处理下拉框
     * Select类用于定位<select>标签。selectByValue()方法符用于选取<option>标签的value值
     */
    private static void SelectWindow(WebDriver driver) throws InterruptedException {

        WebDriver driver11;
        driver11 = driver;

        //以百度搜索设置页面的下拉框为例
        driver11.findElement(By.linkText("设置")).click();
        driver11.findElement(By.linkText("搜索设置")).click();
        Thread.sleep(2000);

        //<select>标签的下拉框选择
        WebElement el = driver11.findElement(By.xpath("//select"));
        Select sel = new Select(el);
        sel.selectByValue("20");
        Thread.sleep(2000);

        driver11.quit();
    }


    //警告框处理
    /**
     * 在WebDriver中处理JavaScript所生成的alert、confirm以及prompt
     * 1. 使用switchTo().alert()方法定位到alert/confirm/prompt
     * 2. 使用text/accept/dismiss/sendKeys等方法进行操作
     * -----------------------------------------------
     * getText()： 返回 alert/confirm/prompt 中的文字信息
     * accept()： 接受现有警告框
     * dismiss()： 解散现有警告框
     * sendKeys(keysToSend)： 发送文本至警告框
     * keysToSend： 将文本发送至警告框
     */
    private static void AlertDemo(WebDriver driver) throws InterruptedException {

        WebDriver driver12;
        driver12 = driver;

        //类似百度设置的弹出框是不能通过前端工具对其进行定位的，这时候就要用到switchTo().alert()了
        driver.findElement(By.linkText("设置")).click();
        driver.findElement(By.linkText("搜索设置")).click();
        Thread.sleep(2000);

        //点击保存设置
        driver12.findElement(By.linkText("保存设置")).click();

        System.out.println(driver12.switchTo().alert().getText());

        //接收弹框
        driver12.switchTo().alert().accept();
        Thread.sleep(2000);

        driver12.quit();
    }


    //文件上传 *
    /**
     * 对于通过input标签实现的上传功能,可以将其看作是一个输入框,可通过sendKeys()指定本地文件路径的方式实现文件上传
     */
    private static void FileUpload(WebDriver driver) throws InterruptedException {

        WebDriver driver13;
        driver13 = driver;

        //找到绝对路径
        File file = new File(" ./xxx(路径)/xxx(路径)/文件");
        String filePath = file.getAbsolutePath();
        driver13.get(filePath);

        //定位上传按钮,添加本地文件
        driver13.findElement(By.name("file")).sendKeys("E:\\\\upload_file.txt");
        Thread.sleep(2000);

        driver13.quit();
    }


    //浏览器Cookie操作
    /**
     * WebDriver操作Cookie相关方法
     * getCookies(): 获得所有cookie信息
     * getCookieNamed(String name): 返回字典的key为"name"的Cookie信息
     * addCookie(cookie dict): 添加Cookie, "cookie dict"指字典对象,必须有 name和 value值
     * deleteCookieNamed(String name): 删除Cookie信息, "name"是要删除的 cookie的名称; "optionsString"是该Cookie 的选项, 目前支持"路径"、"域"
     * deleteAllCookies(): 删除所有的cookie 信息
     */
    private static void BorwserCookie(WebDriver driver) {

        WebDriver driver14;
        driver14 = driver;

        Cookie cookie1 = new Cookie("name", "key-aaaaa");
        Cookie cookie2 = new Cookie("value", "value-bbbbb");
        driver14.manage().addCookie(cookie1);
        driver14.manage().addCookie(cookie2);

        //获得 Cookie
        Set<Cookie> cookies = driver14.manage().getCookies();
        System.out.println(cookies);

        //删除所有 cookie
        //driver.manage().deleteAllCookies();
        driver14.quit();
    }


    //调用JavaScript代码
    /**
     * WebDriver提供了 executeScript()方法来执行 JavaScript代码
     * 以调整浏览器滚动条位置为例
     */
    private static void JavaScript(WebDriver driver) throws InterruptedException {

        WebDriver driver15;
        driver15 = driver;

        //设置浏览器窗口大小
        driver15.manage().window().setSize(new Dimension(700, 600));
        Thread.sleep(2000);

        //百度搜索
        driver15.findElement(By.id("kw")).sendKeys("Selenium");
        driver15.findElement(By.id("su")).click();
        Thread.sleep(2000);

        //将页面滚动条拖动
        ((JavascriptExecutor)driver15).executeScript("window.scrollTo(100,410)");
        Thread.sleep(200);
        ((JavascriptExecutor)driver15).executeScript("window.scrollTo(100,420)");
        Thread.sleep(200);
        ((JavascriptExecutor)driver15).executeScript("window.scrollTo(100,430)");
        Thread.sleep(200);
        ((JavascriptExecutor)driver15).executeScript("window.scrollTo(100,440)");
        Thread.sleep(200);
        ((JavascriptExecutor)driver15).executeScript("window.scrollTo(100,450)");
        Thread.sleep(200);

        driver15.quit();
    }


    //窗口截图
    private static void ScreenShot(WebDriver driver) {

        WebDriver driver16;
        driver16 = driver;

        File srcFile = ((TakesScreenshot)driver16).getScreenshotAs(OutputType.FILE);
        try {
            org.apache.commons.io.FileUtils.copyFile(srcFile, new File("/Users/didi/Downloads/png/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver16.quit();
    }
}
