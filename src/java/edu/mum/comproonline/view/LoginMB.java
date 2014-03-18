/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.view;

import edu.mum.comproonline.control.LoginControlBean;
import edu.mum.comproonline.model.UserEnum;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class LoginMB {

    /**
     * Creates a new instance of LoginMB
     */
    public LoginMB() {
    }
    @EJB
    private LoginControlBean loginController;
    private String username;
    private String password;
    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

   public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String checkLogin() throws Exception {

        int result = loginController.checkLogin(this);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

       if (result == UserEnum.ADMIN.ordinal()) {
            session.setAttribute("susername", this.username);
            session.setAttribute("srole", UserEnum.ADMIN);
            facesContext.getExternalContext().redirect("../Admin/adminHomePage.xhtml");

        } else if (result == UserEnum.APPLICANT.ordinal()) {
            session.setAttribute("susername", this.username);
            session.setAttribute("srole", UserEnum.APPLICANT);
            facesContext.getExternalContext().redirect("../applicant/applicantHomePage.xhtml");
        } else if (result == UserEnum.STAFF.ordinal()) {
            session.setAttribute("susername", this.username);
            session.setAttribute("srole", UserEnum.STAFF);
            facesContext.getExternalContext().redirect("../admissionStaff/admissionStaffHomePage.xhtml");
        } else if (result == -1) {
            this.errormessage = "UserName or Password is incorrect try agaain !!!";
        }

        return "login.xhtml";
    }
    
    //TODO:
    public String logout() {
        //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "../general/login.xhtml?faces-redirect=true";
    }

}
