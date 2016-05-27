package com.sendmail.override;

import java.text.ParseException;

import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.quartz.CronTriggerBean;

import com.sendmail.conf.Configure;

public class MailCronTrigger extends CronTriggerBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void setCronExpression(String cronExpression) throws ParseException{
		String cronExpressionConf=Configure.getProperty(Configure.MESSAGE_CRON);
		if(!StringUtils.isEmpty(cronExpressionConf)){
			cronExpression=cronExpressionConf;
		}
		super.setCronExpression(cronExpression);
	}

}
