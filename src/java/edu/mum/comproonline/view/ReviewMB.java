/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.view;

import edu.mum.comproonline.control.ApplicationStatusControlBean;
import edu.mum.comproonline.control.EvaluationControlBean;
import edu.mum.comproonline.model.AppEvaluationStatusEnum;
import edu.mum.comproonline.model.AppSubmitStatusEnum;
import edu.mum.comproonline.model.ApplicationDAO;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.EnglishproTbl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dipesh
 */
@ManagedBean
@RequestScoped
public class ReviewMB {

    @EJB
    ApplicationDAO applicationDAO;
    /**
     * Creates a new instance of ReviewMB
     */
    public ReviewMB() {
    }
    
    public Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public void loadApplicationData() {
        // pass value to EJB
        ApplicationTbl app = applicationDAO.getApplication(userId);
       
        this.eval.setApplication(app);       
        Logger.getGlobal().log(Level.INFO, "Loading Application Data for userId...." + userId);
    }
    
    @PostConstruct
    public void init() {
        this.eval = new EvaluationControlBean();
    }
    
    @EJB
    private ApplicationStatusControlBean appStatusControl;
    
    //@EJB
    private EvaluationControlBean eval;

    public EvaluationControlBean getEval() {
        return eval;
    }

    public void setEval(EvaluationControlBean eval) {
        this.eval = eval;
    }
            
    private Integer submittedStatus;
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    
    public Integer getSubmittedStatus() {
        return submittedStatus;
    }

    public void setSubmittedStatus(Integer submittedStatus) {
        this.submittedStatus = submittedStatus;
    }

    public String setAppStatusAccepted() {
       //String email = session.getAttribute("susername").toString(); 
       appStatusControl.evalStatus(AppEvaluationStatusEnum.ACCEPTED.ordinal(), userId);       
       return "/pages/admissionStaff/reviewForm.xhtml";
    }

    public String setAppStatusRejected() {
       appStatusControl.evalStatus(AppEvaluationStatusEnum.REJECTED.ordinal(), userId);  
       return "/pages/admissionStaff/reviewForm.xhtml";
    }
    
    public String setSubmitStatusUnsubmitted()
    {
        FacesMessage message = new FacesMessage("Application has been set to UNSUBMITTED!");
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage("setSubmitBtn", message);
        
        Logger.getGlobal().log(Level.INFO, "setSubmitStatusUnsubmitted...." + userId);
        appStatusControl.submittedStatus(AppSubmitStatusEnum.UNSUBMITED.ordinal(), userId);
        return "/pages/admissionStaff/reviewForm.xhtml";
    }
}
