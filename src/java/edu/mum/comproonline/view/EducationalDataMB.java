/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.view;

import edu.mum.comproonline.model.ApplicationDAO;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.EducationalDataDAO;
import edu.mum.comproonline.model.EducationaldataTbl;
import edu.mum.comproonline.model.InstituteDAO;
import edu.mum.comproonline.model.InstituteTbl;
import edu.mum.comproonline.model.LoginDAO;
import edu.mum.comproonline.model.UserTbl;
import edu.mum.comproonline.util.JsfUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Nazanin
 */
@ManagedBean
@RequestScoped
public class EducationalDataMB {
    @EJB
    LoginDAO loginDAO;
    @EJB
    ApplicationDAO applicationDAO;
    @EJB
    InstituteDAO instituteDAO;
    @EJB
    EducationalDataDAO educationalDAO;

    private List<InstituteTbl> institutes;
    private EducationaldataTbl educationalData;
    private InstituteTbl institute;
    private ApplicationTbl application;
    private UserTbl user;
    private Date date;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
     /**
     * Creates a new instance of EducationalDataMB
     */
    public EducationalDataMB() 
    {
         this.institute = new InstituteTbl();
    }
    

    public EducationaldataTbl getEducationalData() {
        return educationalData;
    }

    public void setEducationalData(EducationaldataTbl educationalData) {
        this.educationalData = educationalData;
    }

    public InstituteTbl getInstitute() {
        return institute;
    }

    public void setInstitute(InstituteTbl institute) {
        this.institute = institute;
    }

    public ApplicationTbl getApplication() {
        return application;
    }

    public void setApplication(ApplicationTbl application) {
        this.application = application;
    }

    public UserTbl getUser() {
        return user;
    }

    public void setUser(UserTbl user) {
        this.user = user;
    }

    
     public List<InstituteTbl> getInstitutes() {
        return institutes;
    }

    public void setInstitutes(List<InstituteTbl> institutes) {
        this.institutes = institutes;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void onEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Institute Edited", ((InstituteTbl) event.getObject()).getInstituteName());
        //edit method
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Institute Cancelled", ((InstituteTbl) event.getObject()).getInstituteName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
     /**
     * Load  Educational data of Current Logged applicant
     * @author Nazanin
     */
  @PostConstruct
    public void init() {
        String email = session.getAttribute("susername").toString();        
        this.user = loginDAO.findApplicantByEmailAddr(email);
 
        this.application =  applicationDAO.getApplication(user.getUserID());
        if(application != null) {
        
            this.educationalData =application.getEducationaldataTbl();
            
            if(this.educationalData == null)
            {
              
               this.institutes = new ArrayList<>();
               this.educationalData = new EducationaldataTbl();
               
            }
            else
            {
                Collection ins = educationalData.getInstituteTblCollection();
                
               if(ins ==  null || ins.isEmpty() )
                {
                    this.institutes = new ArrayList<>();
                    educationalData.setInstituteTblCollection(institutes);
                   
                }
                else
                {
                     this.institutes = new ArrayList<>();
                     this.institutes.addAll(ins);
                    
                }
            }
        }else {
            
            this.institutes = new ArrayList<>();
            this.educationalData = new EducationaldataTbl();
        }
    }
    
     /**
     * Save the current Educational data
     * @author Nazanin
     */
    public void saveEducatinalData() {
         this.institutes.add(institute);
         this.instituteDAO.saveInstituteData(institute);
         this.educationalData.setInstituteTblCollection(institutes);
         this.educationalDAO.saveEducationalData(educationalData);
         this.application.setEducationaldataTbl(educationalData);
         this.applicationDAO.saveApplication(application);
         JsfUtil.addSuccessMessage("English Data Saved Successfully");
        
    }
}
