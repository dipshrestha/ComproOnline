/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.view;

import edu.mum.comproonline.control.RegistrationControlBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Ethiopia
 */
@ManagedBean
@RequestScoped
public class RetrievePasswordMB {

    @Pattern(regexp = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[a-zA-Z]{2,4}$", message = "Invalid email format")
    private String userEmail;

    @EJB
    RegistrationControlBean myRegControlBean;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Creates a new instance of retrievePasswordMB
     */
    public RetrievePasswordMB() {
    }

    public String retrievePassword() throws Exception {
        if (!(myRegControlBean.emailExists(this.getUserEmail()))) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("The Email provided doesn't Exist!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(userEmail, message);
            return null;
        }
        myRegControlBean.retrievePassword(this.getUserEmail());
        return "/pages/general/retrievePasswordConfirmation.xhtml";
    }

}
