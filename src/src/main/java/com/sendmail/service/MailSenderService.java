package com.sendmail.service;

import com.sendmail.model.MailModel;

/**
 * 邮件发送Service
 * @author root
 *
 */
public interface MailSenderService {
      
    /** 
     * 发送模板邮件 
     */  
    public void sendWithTemplate(MailModel mail); 
    /** 
     * 发送普通文本邮件 
     */  
    public void sendText(MailModel mail); 
    /** 
     * 发送普通Html邮件 
     */  
    public void sendHtml(MailModel mail);  
    /** 
     * 发送普通带一张图片的Html邮件 
     */  
    public void sendHtmlWithImage(MailModel mail);  
    /** 
     * 发送普通带附件的Html邮件 
     */  
    public void sendHtmlWithAttachment(MailModel mail);  
   /**
    * 通过模板生产HTML文件同时,替换模板中的图片 
    * @param mail
    */
    public void sendHtmlTempalateWithImage(MailModel mail);
}
