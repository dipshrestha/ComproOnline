/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.control;

import edu.mum.comproonline.util.JsfUtil;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author Nazanin
 */
@Named("ApplicationControlBean")
@SessionScoped
public class ApplicationControlBean implements Serializable{

     public ApplicationControlBean() {
    }
    
     @EJB
     private  edu.mum.comproonline.view.LoginMB loginMB;
     private edu.mum.comproonline.model.UserDAO userDAO;
     private edu.mum.comproonline.model.ApplicationDAO applicationDAO;
     
     public String prepareApplication()
     {
         String returnPage = null;
         String email = loginMB.getUsername(); //???????
         Integer userID = userDAO.getUserIDByEmail(email);
         Integer appID = applicationDAO.getApplicationID(userID);
         Integer appStatus = applicationDAO.getApplicationStatus(userID);
         if( appID != null)
         {
             if(appStatus == 0) //not submitted
             {
                 //fetch data for edit
                 try
                 {
                     returnPage =  "viewApplicationForm";
                     
                 }catch(Exception e)
                 {
                      JsfUtil.addErrorMessage(e,"PersistenceErrorOccured");
                      returnPage = "viewApplicationForm";
                 }

             }
             else
             {
                 //display message
                 JsfUtil.addErrorMessage("You have already submit your application");
                 returnPage = "applicantHomePage";
                 
             }
         }else
         {
             //create
             returnPage = "newApplicationForm";
         }
         return returnPage;
     }
}
