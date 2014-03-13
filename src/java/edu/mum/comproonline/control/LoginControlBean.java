/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.control;

import edu.mum.comproonline.model.LoginDAO;
import edu.mum.comproonline.model.UserTbl;
import edu.mum.comproonline.util.HashServices;
import edu.mum.comproonline.view.LoginMB;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class LoginControlBean {

    @EJB
    LoginDAO loginEntityDAO;
    private String userName;
    private String password;
    private UserTbl userFound;

    public int checkLogin(LoginMB loginMB) throws Exception {

        userName = loginMB.getUsername();
        password = new HashServices(loginMB.getPassword()).getMessageDigest();

        userFound = loginEntityDAO.findApplicantByEmailAddr(userName, password);

        if (userFound == null) {
            return -1;
        }

        if (userName.equals(userFound.getUserEmail()) && password.equals(userFound.getUserPassword())) {

            return userFound.getUserRole();
        } else {
            return -1;
        }

    }

}
