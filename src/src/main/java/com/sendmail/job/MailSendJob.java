package com.sendmail.job;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.json.JSONUtil;

import com.sendmail.conf.Configure;
import com.sendmail.model.MailModel;
import com.sendmail.service.MailSenderService;

/**
 * 邮件发送Job
 * @author root
 *
 */
public class MailSendJob {

	
	/**
	 * 发送邮件Service
	 */
	private MailSenderService mailSenderService;
	
	private static Logger logger = Logger.getLogger(MailSendJob.class);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void execute(){
		
		//从配置文件中读取模板数据和模板
		Map<String,String> properties = Configure.getProperties(); 
		String messageTemplate=properties.get(Configure.MESSAGE_TEMPLATE);
		String messageTemplateData=Configure.getTemplateDir()+properties.get(Configure.MESSAGE_TEMPLATEDATA);
		
		
		logger.info("Load message template :"+messageTemplate);
		logger.info("Load message template data:"+messageTemplateData);
		
		//读取Json模板数据加载到Map中
		Map templateMode=null;
		try {
			
			InputStreamReader read = new InputStreamReader (new FileInputStream(messageTemplateData),Configure.CHAR_SET_GBK);
			BufferedReader reader=new BufferedReader(read);
			templateMode=(Map)JSONUtil.deserialize(reader);
			
			logger.info("deserialize template json data to map success");
		} catch (Exception e) {
			logger.debug("deserialize template json data to map error",e);
		} 
		
		
		String messageForm=(String)templateMode.get("mail_form");
		List messageTos=(List)templateMode.get("mail_to");
		String messageSubJect=(String)templateMode.get("mail_subject");
		
		logger.info("message from:"+messageForm);
		logger.info("message messageTos:"+messageTos.toString()+"...");
		logger.info("message subject:"+messageSubJect);
		
		List failLogs=new ArrayList();
		
		for(int i=0;i<messageTos.size();i++){
			
			MailModel mail=new MailModel();
			mail.setFrom(messageForm);
			mail.setTo((String)messageTos.get(i));
			mail.setSubject(messageSubJect);
			
			mail.setTemplateName(messageTemplate);
			mail.setTemplateMode(templateMode);
			
			logger.info("message to:"+(String)messageTos.get(i)+" sending ....");
			try{
				mailSenderService.sendHtmlTempalateWithImage(mail);
				logger.info("message to:"+(String)messageTos.get(i)+" sended!");
			}catch(Exception e){
				logger.debug("message to:"+(String)messageTos.get(i)+" failed!",e);
				failLogs.add(mail);
			}
		}
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		String logTime=format.format(new Date());
		logger.info("["+logTime+"]-[message send]-total:["+messageTos.size()+"]"+" success:["+(messageTos.size()-failLogs.size())+"]"+" fail:["+failLogs.size()+"]");
		
		
	}
	
	
	public MailSenderService getMailSenderService() {
		return mailSenderService;
	}
	public void setMailSenderService(MailSenderService mailSenderService) {
		this.mailSenderService = mailSenderService;
	}
	
	
}
