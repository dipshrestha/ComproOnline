/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.view;

import edu.mum.comproonline.model.AppEvaluationStatusEnum;
import edu.mum.comproonline.model.AppSubmitStatusEnum;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.LoginDAO;
import edu.mum.comproonline.model.SearchDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author dipesh
 */
@ManagedBean
@RequestScoped
public class SearchMB {

    @EJB
    SearchDAO searchDAO;

    private String email;
    private String country;
    private int submitStatus;
    private int evaluationStatus;

    private List<ApplicationTbl> applicantionList;

    public List<ApplicationTbl> getApplicantionList() {
        return applicantionList;
    }

    public void setApplicantionList(List<ApplicationTbl> applicantionList) {
        this.applicantionList = applicantionList;
    }
    /**
     * Creates a new instance of SearchMB
     */
    public SearchMB() {
        // default values
        email = "";
        country = "";
        submitStatus = AppSubmitStatusEnum.SUBMITTED.ordinal();
        evaluationStatus = AppEvaluationStatusEnum.UNDECIDED.ordinal();
        
        applicantionList = new ArrayList<>();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(int submitStatus) {
        this.submitStatus = submitStatus;
    }

    public int getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(int evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

    public void search() {
        applicantionList = searchDAO.searchApplication(this);
    }
}
