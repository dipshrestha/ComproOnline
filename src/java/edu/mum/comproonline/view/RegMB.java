/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.view;

import edu.mum.comproonline.control.RegistrationControlBean;
import edu.mum.comproonline.model.UserEnum;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class RegMB {

    @EJB
    private RegistrationControlBean myRegContBean;

    private String firstName;
    private String middleName;
    private String lastName;
    @Pattern(regexp = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[a-zA-Z]{2,4}$", message = "Invalid email format")
    private String email;
    private String password;
    private String password_2;
    private int roles = UserEnum.APPLICANT.ordinal();
    private int status;
    @Temporal(TemporalType.DATE)
    private Date lastLoginDate;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private String newPassword;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

    public RegistrationControlBean getMyRegContBean() {
        return myRegContBean;
    }

    public void setMyRegContBean(RegistrationControlBean myRegContBean) {
        this.myRegContBean = myRegContBean;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_2() {
        return password_2;
    }

    public void setPassword_2(String password_2) {
        this.password_2 = password_2;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String saveRegInfo() throws Exception {
        if (!(this.getPassword().equals(this.getPassword_2()))) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("passwords donot match!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage("password", message);
            return null;
        }
        if (myRegContBean.emailExists(this)) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("Email is already registered!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage("userEmail", message);
            return null;
        }
        myRegContBean.saveRegInfo(this);

        //return "index.xhtml";
        return "/pages/applicant/registrationConfirmation.xhtml";
    }

    public String resetPassword() throws Exception {

        if (!(this.getNewPassword().equals(this.getPassword_2()))) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("passwords donot match!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage("password", message);
            return null;
        }
        if (!(myRegContBean.isValidUser(session.getAttribute("susername").toString(), this))) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("Incorrect UserName or Password!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage("userEmail", message);
            return null;
        }
        myRegContBean.resetPassword(this,session.getAttribute("susername").toString());
        return "/pages/applicant/resetPasswordConfirmation.xhtml";
    }

}
