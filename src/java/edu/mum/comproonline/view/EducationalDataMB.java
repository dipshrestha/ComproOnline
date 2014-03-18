/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.view;

import edu.mum.comproonline.model.EducationaldataTbl;
import edu.mum.comproonline.model.InstituteTbl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Nazanin
 */
@ManagedBean
@RequestScoped
public class EducationalDataMB {

    private List<InstituteTbl> institutes;
    private InstituteTbl newInstitute;

    public InstituteTbl getNewInstitute() {
        return newInstitute;
    }

    public void setNewInstitute(InstituteTbl newInstitute) {
        this.newInstitute = newInstitute;
    }
    
    private EducationaldataTbl educationalData;
    private Date date;


    /**
     * Creates a new instance of EducationalDataMB
     */
    public EducationalDataMB() 
    {
        institutes = new ArrayList<InstituteTbl>();
    }
    
     public EducationaldataTbl getEducationalData() {
        return educationalData;
    }

    public void setPersonalData(EducationaldataTbl educationalData) {
        this.educationalData = educationalData;
    }
    
     public List<InstituteTbl> getInstitutes() {
        return institutes;
    }

    public void setInstitutes(List<InstituteTbl> institutes) {
        this.institutes = institutes;
    }
    
    public void edit()
    {
        
    }
    public void save()
    {
        
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
        public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
