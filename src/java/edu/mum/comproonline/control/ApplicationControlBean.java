/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.control;

import edu.mum.comproonline.model.ApplicationDAO;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.EnglishProDAO;
import edu.mum.comproonline.model.EnglishproTbl;
import edu.mum.comproonline.model.GreDAO;
import edu.mum.comproonline.model.GreTbl;
import edu.mum.comproonline.model.IeltsDAO;
import edu.mum.comproonline.model.IeltsTbl;
import edu.mum.comproonline.model.LoginDAO;
import edu.mum.comproonline.model.PersonalDataDAO;
import edu.mum.comproonline.model.PersonaldataTbl;
import edu.mum.comproonline.model.ToeflDAO;
import edu.mum.comproonline.model.ToeflTbl;
import edu.mum.comproonline.model.UserTbl;
import edu.mum.comproonline.util.JsfUtil;
import edu.mum.comproonline.view.EnglishProMB;
import edu.mum.comproonline.view.PersonalDataMB;
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
     @EJB
    LoginDAO login;
    @EJB
    ApplicationDAO appDAO;
    @EJB
    EnglishProDAO englishDAO;
    @EJB
    GreDAO greDAO;
    @EJB
    IeltsDAO ieltsDAO;
    @EJB
    ToeflDAO toeflDAO;
    @EJB
    PersonalDataDAO personalDAO;
    
    

     public ApplicationControlBean() {
    }
    
     @EJB
     private  edu.mum.comproonline.view.LoginMB loginMB;
 

     
     public String prepareApplication(PersonalDataMB personalMB)
     {
         String returnPage = null;
         UserTbl currentUser = login.findApplicantByEmailAddr(personalMB.getCurrentEmail());
         ApplicationTbl currentApp = appDAO.getApplicationEntity(currentUser.getUserID());
         Integer appID = currentApp.getAppID();
         Integer appStatus =currentApp.getAppStatus();
         if( appID != null)
         {
             if(appStatus == 0) //not submitted
             {
                 
                 try
                 {
                     //fetch data for edit
                     returnPage =  "newApplicationForm";
                     
                 }catch(Exception e)
                 {
                      JsfUtil.addErrorMessage(e,"PersistenceErrorOccured");
                      returnPage = "viewApplicationForm";
                 }

             }
             else
             {
                 try
                 {
                     JsfUtil.addErrorMessage("You have already submit your application");
                     returnPage="";//REVIEW PAGE
                 }catch(Exception e)
                 {
                     JsfUtil.addErrorMessage(e,"PersistenceErrorOccured");
                     returnPage = "applicantHomePage";
                 }
                 
             }
         }else
         {
             //create
             returnPage = "newApplicationForm";
         }
         return returnPage;
     }
     
     
     
       public void savePersonalData(PersonalDataMB personalMB)
    {
        
      
        UserTbl currentUserp = login.findApplicantByEmailAddr(personalMB.getCurrentEmail());
        ApplicationTbl currentApp = appDAO.getApplicationEntity(currentUserp.getUserID());
        Integer appID = currentApp.getAppID();
        boolean doesHaveApp = appDAO.checkPAppID(appID);

       
       if (doesHaveApp) 
        {
                PersonaldataTbl currentPersonalData= currentApp.getPersonaldataTbl();
                personalDAO.create(currentPersonalData);
                
        }
       
        else 
        {
            ApplicationTbl app = new ApplicationTbl();
            appDAO.createApplication(app);
            app.setAppUserID(currentUserp);
           
            PersonaldataTbl currentPersonalData= new PersonaldataTbl();
            personalDAO.createPersonalData(currentPersonalData);
            app.setPersonaldataTbl(currentPersonalData);

        }
    
    }
       
     /**
      * Save English proficiency data
      * @author Nazanin
      * @param englishMB 
      */
     public void saveEnglishProData(EnglishProMB englishMB) {

        GreTbl gre = englishMB.getGre();
        IeltsTbl ielts = englishMB.getIelts();
        ToeflTbl toefl = englishMB.getToefl();
        EnglishproTbl currentEnData;


        UserTbl currentUser = login.findApplicantByEmailAddr(englishMB.getCurrentEmail());
        ApplicationTbl currentApp = appDAO.getApplicationEntity(currentUser.getUserID());
        Integer appID = currentApp.getAppID();
        boolean doesHaveEnID = appDAO.checkEnglishID(appID);
       

       if (doesHaveEnID) {
            currentEnData = currentApp.getEnglishproTbl();
           
            if (currentEnData.getGreTbl() != null) {
                greDAO.updateGre(gre);
                currentEnData.setGreTbl(gre);
            }
            else
            {
                greDAO.create(gre);
                currentEnData.setGreTbl(gre);
            }
            
           if (currentEnData.getIeltsTbl() != null) {
                ieltsDAO.updateIelts(ielts);
                currentEnData.setIeltsTbl(ielts);
            }
            else
            {
                ieltsDAO.create(ielts);
                currentEnData.setIeltsTbl(ielts);
            }

            if (currentEnData.getToeflTbl() != null) 
            {
                toeflDAO.updateToefl(toefl);
                currentEnData.setToeflTbl(toefl);
                
            }
            else
            {
                toeflDAO.create(toefl);
                currentEnData.setToeflTbl(toefl);
            }

            englishDAO.updateEnglish(currentEnData);

        } else 
        {
            EnglishproTbl english = new EnglishproTbl();
            
            if(gre != null)
            {
                greDAO.create(gre);
                english.setGreTbl(gre);
            }
            if(ielts != null)
            {
               ieltsDAO.create(ielts);
                english.setIeltsTbl(ielts);
            }
            if(toefl != null)    
            {
                 toeflDAO.create(toefl);
                english.setToeflTbl(toefl);
            }
           

            englishDAO.create(english);
            currentApp.setEnglishproTbl(english);
        }
          
    }
}
