package edu.mum.comproonline.control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.mum.comproonline.model.UserDAO;
import edu.mum.comproonline.model.UserEnum;
import edu.mum.comproonline.model.UserTbl;
import edu.mum.comproonline.util.HashServices;
import edu.mum.comproonline.util.RandomStringGenerator;
import edu.mum.comproonline.view.RegMB;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class RegistrationControlBean {

    @EJB
    UserDAO myApplicantDAO;
    HashServices myHashService;
    UserTbl oldUser;

    @EJB
    private EmailControlBean emailController;
    private String emailForemail;
    private String emailForpassword;
    private int role;

    /**
     * author Abraham
     *
     * @param regMB
     * @throws Exception
     */
    public void saveRegInfo(RegMB regMB) throws Exception {
        UserTbl newAppl = new UserTbl();
        newAppl.setUserFirstName(regMB.getFirstName());
        newAppl.setUserMiddleName(regMB.getMiddleName());
        newAppl.setUserLastName(regMB.getLastName());
        newAppl.setUserEmail(regMB.getEmail());
        myHashService = new HashServices();
        myHashService.setPassWord(regMB.getPassword().toString());
        newAppl.setUserPassword(myHashService.getMessageDigest());

        newAppl.setUserRole(regMB.getRoles());
        newAppl.setUserStatus(1);

        Calendar cal = Calendar.getInstance();
        newAppl.setUserLastLoginDate(null);
        newAppl.setUserCreationDate(cal.getTime());

        myApplicantDAO.create(newAppl);
    }

    /**
     * author Abraham
     *
     * @param email
     * @return
     * @throws Exception
     */
    public boolean emailExists(String email) throws Exception {
        int counter = myApplicantDAO.countEmails(email);
        if (counter > 0) {
            return true;
        }
        return false;

    }

    /**
     * author Abraham
     *
     * @param email
     * @param regMB
     * @return
     * @throws Exception
     */
    public boolean isValidUser(String email, RegMB regMB) throws Exception {
        if (myApplicantDAO.getUserTbl(email).isEmpty()) {
            return false;
        } else {
            oldUser = myApplicantDAO.getUserTbl(email).get(0);
            HashServices myHashServicePassword = new HashServices();
            myHashServicePassword.setPassWord(regMB.getPassword());
            if (!myHashServicePassword.getMessageDigest().equals(oldUser.getUserPassword())) {
                return false;
            }
        }
        return true;

    }

    /**
     * author Abraham
     *
     * @param newPassword
     * @param email
     * @throws Exception
     */
    public void resetPassword(String newPassword, String email) throws Exception {
        myHashService = new HashServices(newPassword);
        oldUser = myApplicantDAO.getUserTbl(email).get(0);
        oldUser.setUserPassword(myHashService.getMessageDigest());
        myApplicantDAO.edit(oldUser);

    }

    /**
     * author Abraham
     *
     * @param email
     * @throws java.lang.Exception
     */
    public void retrievePassword(String email) throws Exception {
        String newPassword = RandomStringGenerator.generateRandomString(10, RandomStringGenerator.Mode.ALPHANUMERIC);
        resetPassword(newPassword, email);
        emailController.generateEmailForRetrievePassword(email, newPassword);
    }

}
