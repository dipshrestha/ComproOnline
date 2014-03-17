/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.control;

import java.util.Calendar;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author User
 */
@Stateless
public class EmailControlBean {

    final String username = "gpa.application@gmail.com";
    final String password = "gpa.application1";

    public EmailControlBean() {

    }

    /**
     * *
     * Generate Email after new Applicant registration.
     *
     * @param strTo
     */
    public void generateEmailForNewAppRegistration(String strTo) {
        String strSubject = "Confirmation Email for registration";
        String strMessage = "Welcome to Compro Online System. " + "Your registration is confirmed.\n"
                + "Do not reply this is system generated email.";

        sendEmail(strTo, strSubject, strMessage);
    }

    /**
     * *
     * Generate Email after new staff registration.
     *
     * @param strTo
     * @param password
     */
    public void generateEmailForNewStaffRegistration(String strTo, String password) {

        String strSubject = "Confirmation Email for registration";
        String strMessage = "Welcome to Compro Online System. " + "Your registration is confirmed.\n" + "Your user name : " + strTo + "And Password :" + password + "\n"
                + "Do not reply this is system generated email.";

        sendEmail(strTo, strSubject, strMessage);

    }

    /**
     * *
     * Generate Email after form submission to the applicant.
     *
     * @param strTo
     */
    public void generateEmailForFormSubmission(String strTo) {

        String strSubject = "Confirmation Email for Application Submission";
        String strMessage = "Welcome to Compro Online System. " + "Your registration is confirmed.\n"
                + "Do not reply this is system generated email.";
        sendEmail(strTo, strSubject, strMessage);

    }

    /**
     * *
     * Generate Email when Evaluation is changed.
     *
     * @param strTo
     */
    public void generateEmailForEvaluation(String strTo) {

        String strSubject = "Confirmation Email for registration";
        String strMessage = "Welcome to Compro Online System. " + "Your registration is confirmed.\n"
                + "Do not reply this is system generated email.";

        sendEmail(strTo, strSubject, strMessage);

    }

    /**
     * 
     *Generate email when status will changed.
     * @param strTo
     */
    public void generateEmailForStatus(String strTo) {

        String strSubject = "Confirmation Email for registration";
        String strMessage = "Welcome to Compro Online System. " + "Your registration is confirmed.\n"
                + "Do not reply this is system generated email.";
        sendEmail(strTo, strSubject, strMessage);

    }
    /**
     * 
     * @param strTo
     * @param newPassword 
     */
    public void generateEmailForRetrievePassword(String strTo,String newPassword) throws Exception{

        String strSubject = "New password";
        String strMessage = "Since you requested new password we have sent you this email " 
                + "\n Now your new password is "+newPassword+"\n"
                + "Do not reply this is system generated email.";
        sendEmail(strTo, strSubject, strMessage);

    }

    /**
     * Generate email after reset user password.
     * @param strTo 
     */
    public void generateEmailForResetPassword(String strTo) {
        Calendar cal = Calendar.getInstance();
        String strSubject = "Password Changed.";
        String strMessage = "Dear Applicant,\n\n"
                + "We are sending you this email because your password has been changed at " + cal.getTime() + "\n"
                + " If you changed your password ,then you can disregard this email.\n"
                + "But if you don't please contact us.";

        sendEmail(strTo, strSubject, strMessage);

    }
    /**
     * author Abraham
     * @param strTo
     * @param password
     * @throws Exception 
     */
    public void generateEmailForCreateNewStaff(String strTo,String password)throws Exception{         
        String strSubject = "Account Created";
        String strMessage = "CS Admin has created an Admission Staff Account for you " 
                + "\nYour User id is "+strTo+"\n"
                + "Your password is "+password+"\n"
                + "Do not reply, this is system generated email.";
        sendEmail(strTo, strSubject, strMessage);
        
    }

    public void sendEmail(String strTo, String strSubject, String strMessage) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gpa.application@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(strTo));
            message.setSubject(strSubject);
            message.setText(strMessage);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}

