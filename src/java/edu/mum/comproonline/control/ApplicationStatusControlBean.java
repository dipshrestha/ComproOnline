/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.control;

import edu.mum.comproonline.model.ApplicationDAO;
import edu.mum.comproonline.model.ApplicationTbl;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class ApplicationStatusControlBean {

    @EJB
    private ApplicationDAO appDAO;
    @EJB
    private EmailControlBean emailcontrolbean;
    private ApplicationTbl app;

    public void statusAcceptedRejected(int status) {

        app = (ApplicationTbl) appDAO.getApplicationIDForStatus(1);

        if (app != null) {
            app.setAppScore(status);
            appDAO.updateStatus(app);
            
            // TODO: Send Email to Applicant
            emailcontrolbean.generateEmailForEvaluation("shohagcoe@gmail.com");
        }
    }

    public void submittedStatus(int status) {

        app = (ApplicationTbl) appDAO.getApplicationIDForStatus(1);

        if (app != null) {

            app.setAppStatus(status);
            appDAO.updateStatus(app);
            
            //  TODO: Send Email to Applicant
            emailcontrolbean.generateEmailForStatus("shohagcoe@gmail.com");
        }
    }
}

