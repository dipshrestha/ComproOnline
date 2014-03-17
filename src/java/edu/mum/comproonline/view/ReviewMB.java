/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.view;

import edu.mum.comproonline.control.ApplicationStatusControlBean;
import edu.mum.comproonline.control.EvaluationControlBean;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.EnglishproTbl;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author dipesh
 */
@ManagedBean
@RequestScoped
public class ReviewMB {

    /**
     * Creates a new instance of ReviewMB
     */
    public ReviewMB() {
        // pass value to EJB
        ApplicationTbl application = new ApplicationTbl(1234);
        EnglishproTbl englishproTbl = new EnglishproTbl();
        englishproTbl.setEnListeningAbility(3);
        englishproTbl.setEnReadingWritingAbility(4);
        englishproTbl.setEnSpeakingAbility(4);
        application.setEnglishproTbl(englishproTbl);
        
        evaluationControlBean = new EvaluationControlBean(application);
        //evaluationControlBean.setApplication(new ApplicationTbl());
    }
    
    @EJB
    private ApplicationStatusControlBean appStatusControl;
    
    @EJB
    private EvaluationControlBean evaluationControlBean;
            
    private Integer submittedStatus;

    public Integer getSubmittedStatus() {
        return submittedStatus;
    }

    public void setSubmittedStatus(Integer submittedStatus) {
        this.submittedStatus = submittedStatus;
    }

    public String statusAccepted() {
        
       appStatusControl.statusAcceptedRejected(1);
       
       return "/pages/admissionStaff/reviewForm.xhtml";

    }

    public String statusRejected() {
        
        appStatusControl.statusAcceptedRejected(2);

        return "/pages/admissionStaff/reviewForm.xhtml";
    }
    
    public String submittedStatus()
    {
        appStatusControl.submittedStatus(submittedStatus);
        return "/pages/admissionStaff/reviewForm.xhtml";
        
    }
    
}
