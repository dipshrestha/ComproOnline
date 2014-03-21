/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.view;

import edu.mum.comproonline.model.AppEvaluationStatusEnum;
import edu.mum.comproonline.model.AppSubmitStatusEnum;
import edu.mum.comproonline.model.ApplicationDAO;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.LoginDAO;
import edu.mum.comproonline.model.PersonaldataTbl;
import edu.mum.comproonline.model.UserDAO;
import edu.mum.comproonline.model.UserTbl;
import edu.mum.comproonline.util.JsfUtil;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import edu.mum.comproonline.util.Menucountry;
import java.io.IOException;
import javax.annotation.PostConstruct;

/**
 *
 * @author Nazanin
 */
@ManagedBean
@RequestScoped
public class PersonalDataMB {

    @EJB
    ApplicationDAO applicationDAO;
    @EJB
    UserDAO userDAO;    
    @EJB
    LoginDAO loginDAO;
    
    private ArrayList<String> allCountries = new ArrayList<>();
    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

    private ApplicationTbl application;
    private PersonaldataTbl personalData;
    private UserTbl user;

    public PersonaldataTbl getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonaldataTbl personalData) {
        this.personalData = personalData;
    }
    
    public ArrayList<String> getAllCountries() {
        return allCountries;
    }

    public PersonalDataMB() {
        String filePath = facesContext.getExternalContext().getRealPath("/resources/files/countryList.txt");
        Menucountry countryUtil = new Menucountry(filePath);
        allCountries = countryUtil.getCountries();
    }
    
    /**
     * Load the PersonalData of Current Logged applicant
     */
    @PostConstruct
    public void init() {
        String email = session.getAttribute("susername").toString();        
        this.user = loginDAO.findApplicantByEmailAddr(email);
 
        this.application =  applicationDAO.getApplication(user.getUserID());
        if(application != null) {
            this.personalData = application.getPersonaldataTbl();
        }else {
            this.personalData = new PersonaldataTbl();
            this.application = new ApplicationTbl();
        }
    }
    
    /**
     * Save the current PersonalData
     */
    public void save() {
        // BUG: creating two rows of PersonalData when application is created for first time.
        this.application.setAppEvalStatus(AppEvaluationStatusEnum.UNDECIDED.ordinal());
        this.application.setAppSubmitStatus(AppSubmitStatusEnum.UNSUBMITED.ordinal());
        this.applicationDAO.savePersonalData(this.personalData);
        this.application.setPersonaldataTbl(personalData);
        this.application.setAppUserID(user);
        this.applicationDAO.saveApplication(this.application);
        
        // show msg
        JsfUtil.addSuccessMessage("Application Successfully Saved.");
    }
    /**
     * @author Nazanin
     * @return 
     */
    public String getStatus()
    {
        String email = session.getAttribute("susername").toString();        
        this.user = loginDAO.findApplicantByEmailAddr(email);
        this.application =  applicationDAO.getApplication(user.getUserID());
        Integer eval =  this.application.getAppEvalStatus();
        if(eval == AppEvaluationStatusEnum.ACCEPTED.ordinal())
        {
            return "Congratulations! You have been accepted.";
        }
        else if(eval == AppEvaluationStatusEnum.REJECTED.ordinal())
        {
            return "Sorry! You have been rejected.";
        }
        else
        {
            return "Undecided.";
        }
    }
    /**
     * @author Nazanin
     */
    public String submit()
    {
        this.application.setAppSubmitStatus(AppSubmitStatusEnum.SUBMITTED.ordinal());
        return"applicationConfirmation";
    }
    /**
     * @author Nazanin
     * @return 
     */
    public void prepareApp()
    {
        String returnPage;
        FacesContext facesContext =FacesContext.getCurrentInstance();
        String email = session.getAttribute("susername").toString();        
        this.user = loginDAO.findApplicantByEmailAddr(email);
        this.application =  applicationDAO.getApplication(user.getUserID());
        Integer submit =  this.application.getAppSubmitStatus();
        if(submit == AppSubmitStatusEnum.SUBMITTED.ordinal())
        {
           try{
            facesContext.getExternalContext().redirect("applicationConfirmation.xhtml");
            return;
           }
           catch(IOException e)
           {
               JsfUtil.addErrorMessage("Error redirecting to page.");
           }
            
        }
        else
        {
            try{
            facesContext.getExternalContext().redirect("newApplicationForm");
            return;
           }
           catch(IOException e)
           {
               JsfUtil.addErrorMessage("Error redirecting to page.");
           }
           
        }
        
    }
  
     
}
