package com.heima.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

/**
 * 〈功能简述〉
 * 〈〉
 *
 * @author riten
 * @FileName com.heima.freemarker.FreemarkerTest
 * @create 2018/10/18 21:53
 * @since 1.0.0
 */

public class FreemarkerTest {

    public static void main(String[] args) throws Exception {
        //创建一个Configuraion对象
        Configuration configuration = new Configuration();

        //设置文件所在模板所在的路径
        configuration.setDirectoryForTemplateLoading(new File("F:\\Work\\JavaEE_58\\pingyougou\\freemarker_demo\\src\\main\\resources"));

        //设置模板文件使用的字符集 UTF-8
        configuration.setDefaultEncoding("utf-8");

        //加载一个模板，创建一个模板对象
        Template template = configuration.getTemplate("test.ftl");

        //创建一个模板使用的数据集， pojo 或者是Map
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "万五");
        map.put("age", 15);

        List<User> userList = new ArrayList<>();
        for (int i=0; i<5; i++){
            User user = new User();
            user.setName("青青 " + i);
            user.setAge(13 + i);
            userList.add(user);
        }
        map.put("userList", userList);
        map.put("today", new Date());

        map.put("number",2354545);

        map.put("userStr",null);

        //创建一个Writer对象，指定生成的文件名
        Writer out = new FileWriter("F:\\Work\\JavaEE_58\\pingyougou\\freemarker_demo\\src\\main\\resources\\freemarkerTest.html");
        //调用模板对象的process方法输出文件
        template.process(map, out);
        //关闭流
        out.close();
    }
}

