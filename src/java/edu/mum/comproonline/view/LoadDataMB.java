/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.view;

import edu.mum.comproonline.control.LoadDataControlBean;
import edu.mum.comproonline.control.LoginControlBean;
import edu.mum.comproonline.model.UserEnum;
import edu.mum.comproonline.model.UserTbl;
import edu.mum.comproonline.util.HashServices;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dipesh
 */
@ManagedBean
@RequestScoped
public class LoadDataMB {
    
    @EJB
    private LoadDataControlBean loadDataControlBean;
    
    /**
     * Creates a new instance of LoadDataMB
     */
    public LoadDataMB() {
    }
    
        /**
     * Load Dummy Data into the system
     */
    public void loadData() {
        
        loadDataControlBean.loadData();
        
    }
}
