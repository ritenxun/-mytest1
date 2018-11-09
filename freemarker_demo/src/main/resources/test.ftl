<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>freemarker_demo</title>
</head>
<body>
    <#-- 注释内容 -->
    Hello, ${name}<br/>
    年龄：${age}<br/>

    <#assign username="李四1111111111111111">
    ${username}是谁？<br/>

    <#-- 判断 -->
    <#if (age > 17)>
        成年人
        <#elseif (age > 10 && age < 17)>
        未成年
        <#else >
        小朋友
    </#if><br/>
     <#include "head.ftl">

    <#--循环遍历-->
    <#list userList as user>
        <div>
            <#--${user.name}<br/>
            ${user.age}<br/>-->
            <#assign u=user>
            ${u.name}<br/>
            ${u.age}<br/>
        </div>
    </#list>
    <#--查询集合长度-->
    共有用户人数${userList?size}人<br/>

    <#--字符串转json格式-->
    <#assign user='{"id": 2, "name": "赵敏", "age": 18}'?eval>
    <p>
    ${user.id}
    ${user.name}
    ${user.age}<br/>
    </p>

    <#-- 日期函数 -->
    ${today?date}<br/>
    ${today?time}<br/>
    ${today?datetime}<br/>
    ${today?string("yyyy年MM月dd日 hh:mm:ss")}<br/>


    <#--数字转字符串-->
    ${number?c}<br/>

    <#--为空判断-->
    <#if userStr??>
        不空
        <#else >
        空
    </#if><br/>

    ${userStr!"小"}

</body>
</html>