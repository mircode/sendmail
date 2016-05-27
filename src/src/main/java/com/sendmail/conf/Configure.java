package com.sendmail.conf;

import java.util.Map;

import com.sendmail.override.CustomPropertyConfigurer;

public class Configure {

	//œµÕ≥≈‰÷√
	private static String homeDir;
	private static String logDir;
	private static String tmpDir;
	private static String confDir;
	private static String templateDir;
		
	//” º˛≈‰÷√
	public final static String MESSAGE_FORM="mail.message.from";
	public final static String MESSAGE_TO="mail.message.to";
	public final static String MESSAGE_SUBJECT="mail.message.subject";
	public final static String MESSAGE_TEMPLATE="mail.message.template";
	public final static String MESSAGE_TEMPLATEDATA="mail.message.templateData";
	public final static String MESSAGE_CRON="mail.cron.expression";
	
	public final static String CHAR_SET_GBK="GBK";
	
	public static Map<String, String> getProperties() {  
	        return CustomPropertyConfigurer.getProperties();  
	}  
	      
	public static String getProperty(String key){  
	        return CustomPropertyConfigurer.getProperties().get(key);  
	}

	public static String getLogDir() {
		return logDir;
	}

	public static void setLogDir(String logDir) {
		System.setProperty("SENDMAIL_LOG_DIR",logDir);
		Configure.logDir = logDir;
	}

	public static String getTmpDir() {
		return tmpDir;
	}

	public static void setTmpDir(String tmpDir) {
		System.setProperty("SENDMAIL_TMP_DIR",tmpDir);
		Configure.tmpDir = tmpDir;
	}

	public static String getConfDir() {
		return confDir;
	}

	public static void setConfDir(String confDir) {
		System.setProperty("SENDMAIL_CONF_DIR",confDir);
		Configure.confDir = confDir;
	}

	public static String getHomeDir() {
		return homeDir;
	}

	public static void setHomeDir(String homeDir) {
		System.setProperty("SENDMAIL_HOME_DIR",homeDir);
		Configure.homeDir = homeDir;
	}

	public static String getTemplateDir() {
		return templateDir;
	}

	public static void setTemplateDir(String templateDir) {
		System.setProperty("SENDMAIL_TEMPLATE_DIR",templateDir);
		Configure.templateDir = templateDir;
	}
	
	
}
