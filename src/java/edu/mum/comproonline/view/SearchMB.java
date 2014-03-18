/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.view;

import edu.mum.comproonline.model.AppEvaluationStatusEnum;
import edu.mum.comproonline.model.AppSubmitStatusEnum;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.PersonaldataTbl;
import edu.mum.comproonline.model.SearchDAO;
import edu.mum.comproonline.util.Menucountry;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
public class SearchMB {

    @EJB
    SearchDAO searchDAO;

    private String email;
    private String country;
    private int submitStatus;
    private int evaluationStatus;

    private List<ApplicationTbl> applicantionList;
    private ArrayList<String> allCountries = new ArrayList<>();
    
    public List<ApplicationTbl> getApplicantionList() {
        ApplicationTbl app = new ApplicationTbl(1);
//        app.setAppEvalScore(100);
//        app.setAppSubmitStatus(20);
//        app.setPersonaldataTbl(new PersonaldataTbl(200));
         List<ApplicationTbl> list = new ArrayList<>();
                 list.add(app);
         return list;
        //return applicantionList;
        //return searchDAO.searchApplication(this);
    }

    public ArrayList<String> getAllCountries() {
        return allCountries;
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
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String filePath = facesContext.getExternalContext().getRealPath("/resources/files/countryList.txt");
        Menucountry countryUtil = new Menucountry(filePath);        
        allCountries = countryUtil.getCountries();

    }
    
    @PostConstruct
    public void init() {
        //search();
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

    public String search() {
        this.applicantionList = searchDAO.searchApplication(this);
        //return "/index.html";
        //return "/pages/admissionStaff/searchApplicants1.xhtml";
        return "searchApplicants";
    }
}
