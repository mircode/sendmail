#!/bin/sh

#查看系统是否按照中文字体
#fc-list :lang=zh

#SENDMAIL_HOME环境变量配置
if [ "$SENDMAIL_HOME" = "" ] ;then
		cd ..
		CURRENT_DIR=`pwd`
		SENDMAIL_HOME=$CURRENT_DIR
		export SENDMAIL_HOME=$SENDMAIL_HOME
fi
	

#获取MailSend的PID
PID=`jps|grep MailSend|awk  '{print $1}'`



# 启动服务
doStart()
{
	
	if [ "$PID" = "" ] ;then
		java -Djava.ext.dirs=$SENDMAIL_HOME/lib/  com.sendmail.main.MailSend $2 $3 $4 $5  >/dev/null 2>&1 &
		echo "SendMail process start success!"
	fi
	if [ "$PID" != "" ] ;then
		echo "SendMail process has started!"
	fi
	
}
# 重启服务
doRestart()
{
	if [ "$PID" = "" ] ;then
		echo "SendMail process not start!"
	fi
	if [ "$PID" != "" ] ;then
		kill -9 $PID
		sleep 5s
		java -Djava.ext.dirs=$SENDMAIL_HOME/lib/  com.sendmail.main.MailSend $2 $3 $4 $5 >/dev/null 2>&1 &
		echo "SendMail process restart success!"
	fi
}
# 停止服务
doStop()
{
	
	if [ "$PID" != "" ] ;then
		kill -9 $PID
		echo "SendMail process stop success!"
	fi
	if [ "$PID" = "" ] ;then
		echo "SendMail process had stoped!"
	fi
}
# 查看服务状态
doStatus()
{
	if  [ "$PID" != "" ] ;then
		echo "SendMail process is running!"
	fi

	if [ "$PID" = "" ] ;then
		echo "SendMail process has stoped!"
	fi
}
# 查看服务日志
doLog()
{
	tail -f $SENDMAIL_HOME/logs/sendmail.log
}
# 查看软件版本
doVersion()
{
	echo   SendMail version 0.0.1
}
# 软件使用场景
doUsage()
{
	echo "Usage:  sendmail ( commands ... )"
	echo "commands:"

	echo   "start             start send mail tool"
	echo   "restart           restart send mail tool"
	echo   "stop              stop send mail tool"
	echo   "status            get send mail tool status"
	echo   "version           get send mail tool version"

	echo "sendmail:"
	echo   "pid               $PID"
}
	


case "$1" in 
	start ) doStart ;; 
	restart )  doRestart;; 
	stop ) doStop ;; 
	status ) doStatus ;; 
	version ) doVersion ;; 
	log ) doLog ;; 
	* ) doUsage;;
esac 


