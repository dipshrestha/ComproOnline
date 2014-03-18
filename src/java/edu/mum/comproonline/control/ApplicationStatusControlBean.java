/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.control;

import edu.mum.comproonline.model.AppEvaluationStatusEnum;
import edu.mum.comproonline.model.ApplicationDAO;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.LoginDAO;
import edu.mum.comproonline.model.UserDAO;
import edu.mum.comproonline.model.UserTbl;
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
public class ApplicationStatusControlBean {

    @EJB
    private ApplicationDAO appDAO;
    @EJB
    private UserDAO userDAO;
    
    @EJB
    private EmailControlBean emailcontrolbean;
    private ApplicationTbl app;
    
    public void evalStatus(int status, int userId) {
        String email = userDAO.getUserById(userId).getUserEmail();
        app = (ApplicationTbl) appDAO.getApplicationIDForStatus(userId);
        
        if (app != null) {
            app.setAppEvalStatus(status);
            appDAO.updateStatus(app);

            String statusDisplay = "UNDECIDED";
            if(status == AppEvaluationStatusEnum.ACCEPTED.ordinal()) {
                statusDisplay = "ACCEPTED";
            }else if(status == AppEvaluationStatusEnum.REJECTED.ordinal()) {
                statusDisplay = "REJECTED";
            }
            emailcontrolbean.generateEmailForEvaluation(email, statusDisplay);
        }
    }

    public void submittedStatus(int status, int userId) {
        String email = userDAO.getUserById(userId).getUserEmail();
        app = (ApplicationTbl) appDAO.getApplicationIDForStatus(userId);

        if (app != null) {
            app.setAppSubmitStatus(status);
            appDAO.updateStatus(app);

            emailcontrolbean.generateEmailForStatus(email);
        }
    }
}

