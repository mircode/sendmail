# 定时发送邮件小工具

标签： 邮件发送

- [定时发送邮件小工具](#定时发送邮件小工具)

  - [一、概要](#一概要)
    	- [1、bin目录](#1bin目录)
        - [2、conf目录](#2conf目录)
    	- [3、lib目录](#3lib目录)
        - [4、logs目录](#4logs目录)
    	- [5、temp目录](#5temp目录)
        - [6、template目录](#6template目录)
  - [二、Window下安装](#二Window下安装)
      	- [1、安装软件](#1解压mailsend-0.0.1.tar.gz)
        - [2、启动软件](#2启动软件)
        - [3、维护软件](#2维护软件)
  - [三、Linux下安装](#三Linux下安装)
      	- [1、安装软件](#1解压mailsend-0.0.1.tar.gz)
        - [2、启动软件](#2启动软件)
        - [3、维护软件](#2维护软件)
  - [四、运行截图](#四运行截图)

  
---

##  一、概要
解压mailsend-0.0.1.tar.gz后的目录结构


![目录结构][1]

### 1、bin目录

主要存放软件启动脚本包括Windows和Linux下启动。

![bin目录][2]

### 2、conf目录

mail.properties

![conf目录][3]

可以通过改变mail.properties，来改变软件的一些参数。

### 3、lib目录

sendmail的核心包和依赖包

![lib目录][4]

### 4、logs目录

软件运行的日志存放目录

![logs目录][5]

### 5、temp目录

程序生成的图片存放的临时目录

![temp目录][6]

### 6、template目录

存放邮件模板和模板数据

![template目录][7]

default.vm

![default.vm][8]

default.db

![default.db][9]

## 二、Window下安装

### 1、解压mailsend-0.0.1.tar.gz

![解压mailsend][10]

为了方便启动和维护可以添加环境变量

![修改环境变量][11]

![修改环境变量][12]

### 2、启动软件

![启动软件][13]

![启动软件][14]

### 3、维护软件

查看状态

![查看状态][15]

查看版本

![查看版本][16]

重新启动

![重新启动][17]

![重新启动][18]

停止

![停止][19]

## 三、Linux下安装

### 1、解压mailsend-0.0.1.tar.gz

![目录结构][20]

![解压][21]

为了方便启动和维护可以添加环境变量

![环境变量][22]

![环境变量][23]

添加可执行权限
```
chmod +x mailsend-0.0.1/bin/sendmail.sh 
```

### 2、启动软件

启动并查看日志：
```  
./sendmail.sh start && ./sendmail.sh log
```
![查看状态][24]

### 3、维护软件

查看状态

![查看状态][25]

查看版本

![查看版本][26]

重新启动

![重新启动][28]

停止

![重新启动][27]

## 四、运行截图

![运行截图][29]


  
[1]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/1.png
[2]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/2.png
[3]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/3.png
[4]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/4.png
[5]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/5.png
[6]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/6.png
[7]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/7.png
[8]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/8.png
[9]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/9.png
[10]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/10.png
[11]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/11.png
[12]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/12.png
[13]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/13.png
[14]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/14.png
[15]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/15.png
[16]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/16.png
[17]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/17.png
[18]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/18.png
[19]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/19.png
[20]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/20.png
[21]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/21.png
[22]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/22.png
[23]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/23.png
[24]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/24.png
[25]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/25.png
[26]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/26.png
[27]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/27.png
[28]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/28.png
[29]: https://raw.githubusercontent.com/mircode/sendmail/master/doc/img/29.png
