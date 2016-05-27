package com.sendmail.main;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sendmail.conf.Configure;


/**
 * 发送邮件启动类
 * @author root
 *
 */
public class MailSend {
	
	
	//初始化系统配置
	static{
		String homeDir=System.getenv("SENDMAIL_HOME");
		
		//如果没有设置SENDMAIL_HOME环境变量,读取工程目录下面的配置文件。Just for test
		if(StringUtils.isEmpty(homeDir)){
			//eclipse
			homeDir=System.getProperty("user.dir").toString();
			//maven
			File file=new File(homeDir+"/conf/");
			if(!file.exists()){
				String homeDirT=System.getProperty("user.dir").toString()+"/src/main";
				
				file=new File(homeDirT); 
				if(!file.exists()){
					homeDir=new File(homeDir).getParent().toString();
				}else{
					homeDir=homeDirT;
				}
			}
		}
		
		
		String logDir=homeDir+"/logs/";
		String confDir=homeDir+"/conf/";
		String tmpDir=homeDir+"/temp/";
		String templateDir=homeDir+"/template/";
		
		//设置配置目录
		Configure.setHomeDir(homeDir);
		Configure.setConfDir(confDir);
		Configure.setLogDir(logDir);
		Configure.setTmpDir(tmpDir);
		Configure.setTemplateDir(templateDir);
		
		//设置log配置
		String logConf=homeDir+"/lib/conf/log.conf";
		File file=new File(logConf);
		if(file.exists()){
			PropertyConfigurator.configure(logConf);
		}
		
		//创建临时文件夹和log文件夹
		file=new File(tmpDir);
		if(!file.exists()){
			file.mkdir();
		}
		
		file=new File(logDir);
		if(!file.exists()){
			file.mkdir();
		}
		String infoLog=logDir+"info_log/";
		String debugLog=logDir+"debug_log/";
		String errorLog=logDir+"error_log/";
		
		File infoLogFile=new File(infoLog);
		File debugLogFile=new File(debugLog);
		File errorLogFile=new File(errorLog);
		
		if(!infoLogFile.exists()){
			infoLogFile.mkdir();
		}
		if(!debugLogFile.exists()){
			debugLogFile.mkdir();
		}
		if(!errorLogFile.exists()){
			errorLogFile.mkdir();
		}
		
	}
	
	private static Logger logger = Logger.getLogger(MailSend.class);
	
	@SuppressWarnings("resource")
	public static void main(String args[]){
		
		logger.info("SendMail init....");
		
		//如果用户传入了指定的配置文件路径和模板路径,则使用用户自定义的的配置文件路径和模板路径
	    if(args.length>1){
	    	String confDir=null;
			String templateDir=null;
			
	    	for(int i=0;i<args.length;i++){
	    		
	    		if(args[i].equals("-config")){
	    			i++;
	    			confDir=args[i];
	    		}
	    		if(args[i].equals("-template")){
	    			i++;
	    			templateDir=args[i];
	    		}
	    	}
	    	if(!StringUtils.isEmpty(confDir)){
		    	//重新指定配置目录和模板目录
				Configure.setConfDir(confDir+"/");
				logger.info("用户自定义配置文件目录："+confDir);
	    	}
	    	if(!StringUtils.isEmpty(templateDir)){
		    	//重新指定配置目录和模板目录
	    		Configure.setTemplateDir(templateDir+"/");
	    		logger.info("用户自定义模板文件目录："+templateDir);
	    	}
	    }
		
		
		//启动Spring容器
		logger.info("SendMail start....");
		new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		logger.info("SendMail start success!");
		
	}
}
