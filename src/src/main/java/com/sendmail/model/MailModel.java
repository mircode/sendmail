package com.sendmail.model;

import java.io.Serializable;
import java.util.Map;

public class MailModel implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 邮件发送人
     */
    private String from;
    /**
     * 邮件接受人
     */
    private String to;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;
    
    /**
     * 模板名称
     */
    private String templateName;  
    /**
     * 模板数据
     */
    @SuppressWarnings("rawtypes")
	private Map templateMode;
    /**
     * 附件路径
     */
    private String attachPath;
    /**
     * 图片路径
     */
    //Content="<html><head></head><body><img src=\"cid:image\"/></body></html>";  
    //图片必须这样子：<img src='cid:image'/>  
    private String imagePath;
    /**
     * 是否需要身份验证     
     */
    private boolean validate = false;

    
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	@SuppressWarnings("rawtypes")
	public Map getTemplateMode() {
		return templateMode;
	}

	@SuppressWarnings("rawtypes")
	public void setTemplateMode(Map templateMode) {
		this.templateMode = templateMode;
	}

	public String getAttachPath() {
		return attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}  
    
    
}
