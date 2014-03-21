/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.view;

import edu.mum.comproonline.model.ApplicationDAO;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.EnglishProDAO;
import edu.mum.comproonline.model.EnglishproTbl;
import edu.mum.comproonline.model.GreDAO;
import edu.mum.comproonline.model.GreTbl;
import edu.mum.comproonline.model.IeltsDAO;
import edu.mum.comproonline.model.IeltsTbl;
import edu.mum.comproonline.model.LoginDAO;
import edu.mum.comproonline.model.ToeflDAO;
import edu.mum.comproonline.model.ToeflTbl;
import edu.mum.comproonline.model.UserDAO;
import edu.mum.comproonline.model.UserTbl;
import edu.mum.comproonline.util.JsfUtil;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nazanin
 */
@ManagedBean
@RequestScoped
public class EnglishProMB {

 
    @EJB
    ApplicationDAO applicationDAO;
    @EJB
    UserDAO userDAO;    
    @EJB
    LoginDAO loginDAO;
    @EJB
    EnglishProDAO englishDAO;  
    @EJB
    GreDAO greDAO;
    @EJB 
    ToeflDAO toeflDAO;
    @EJB 
    IeltsDAO ieltsDAO;        
    
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
    private ApplicationTbl application;
    private GreTbl gre;
    private IeltsTbl ielts;
    private ToeflTbl toefl;
    public EnglishproTbl english;
    private UserTbl user;

    public EnglishproTbl getEnglish() {
        return english;
    }

    public void setEnglish(EnglishproTbl english) {
        this.english = english;
    }

    public GreTbl getGre() {
        return gre;
    }

    public void setGre(GreTbl gre) {
        this.gre = gre;
    }

    public IeltsTbl getIelts() {
        return ielts;
    }

    public void setIelts(IeltsTbl ielts) {
        this.ielts = ielts;
    }

    public ToeflTbl getToefl() {
        return toefl;
    }

    public void setToefl(ToeflTbl toefl) {
        this.toefl = toefl;
    }
  
  
    
    public EnglishProMB() 
    {
       
    }

    /**
     * Load  English data of Current Logged applicant
     */
    @PostConstruct
    public void init() {
        String email = session.getAttribute("susername").toString();        
        this.user = loginDAO.findApplicantByEmailAddr(email);
 
        this.application =  applicationDAO.getApplication(user.getUserID());
        if(application != null) {
        
            this.english = application.getEnglishproTbl();
            if(this.english == null)
            {
                this.gre = new GreTbl();
                this.ielts = new IeltsTbl();
                this.toefl = new ToeflTbl();
                this.english = new EnglishproTbl();
            }
            else
            {
                if(english.getGreTbl() == null)
                {
                    this.gre = new GreTbl();
                }
                else
                {
                    this.gre = english.getGreTbl();
                }
                if(english.getIeltsTbl()== null)
                {
                    this.ielts = new IeltsTbl();
                }
                else
                {
                    this.ielts = english.getIeltsTbl();
                }
                if(english.getToeflTbl()== null)
                {
                    this.toefl = new ToeflTbl();
                }
                else
                {
                    this.toefl = english.getToeflTbl();
                }
            }
        }else {
            
            this.gre = new GreTbl();
            this.ielts = new IeltsTbl();
            this.toefl = new ToeflTbl();
            this.english = new EnglishproTbl();
          
        }
    }

    /**
     * Save the current PersonalData
     */
    public void saveEnglishPro() 
     {
         this.greDAO.saveGrehData(this.gre);
         this.ieltsDAO.saveIeltsData(this.ielts);
         this.toeflDAO.saveToeflData(this.toefl);
         this.english.setEnAppID(this.application.getAppID());
         this.englishDAO.saveEnglishData(english);
          this.english.setGreTbl(gre);
         this.english.setIeltsTbl(ielts);
         this.english.setToeflTbl(toefl);
         this.application.setEnglishproTbl(english);
         this.applicationDAO.saveApplication(application);
         JsfUtil.addSuccessMessage("English Data Saved Successfully");
        
    }
    
}