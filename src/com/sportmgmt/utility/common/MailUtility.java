package com.sportmgmt.utility.common;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.SimpleMailMessage;  
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.sportmgmt.utility.constrant.SportConstrant;
   
public class MailUtility{  
    private JavaMailSender mailSender;  
    public void setMailSender(JavaMailSender mailSender) {  
        this.mailSender = mailSender;  
    }  
    private VelocityEngine velocityEngine;
    
    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }
    
    public void sendMail(String from, String to, String subject, String msg) {  
        //creating message  
        SimpleMailMessage message = new SimpleMailMessage();  
        message.setFrom(from);  
        message.setTo(to);  
        message.setSubject(subject);  
        message.setText(msg);  
        //sending message  
        mailSender.send(message);     
    }  
    public void sendHtmlMail(final Map<String,Object> model)
    {
    	MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
               message.setTo((String)model.get(SportConstrant.TO));
              // message.setFrom((String)model.get(SportConstrant.FROM)); // could be parameterized...
               message.setSubject((String)model.get(SportConstrant.SUBJECT));
               /* String text = VelocityEngineUtils.mergeTemplateIntoString(
                  velocityEngine, "com/dns/registration-confirmation.vm","UTF-8", model);*/
               String text = VelocityEngineUtils.mergeTemplateIntoString(
                       velocityEngine, (String)model.get(SportConstrant.VELOCIYY_FILE_LOC),"UTF-8", model);
               message.setText(text, true);
            }
         };
         
         this.mailSender.send(preparator);
    }
}  
