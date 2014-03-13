/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.model;


import edu.mum.comproonline.model.AbstractFacade;
import edu.mum.comproonline.model.ApplicationTbl;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class ApplicationDAO extends AbstractFacade<ApplicationTbl>{

   @PersistenceContext(unitName = "ComproOnlinePU")
   private EntityManager em;
   public ApplicationDAO()
   {
       super(ApplicationTbl.class);
   }
   
   @Override
   protected EntityManager getEntityManager()
   {
       return em;
   }
   
   public Integer getApplicationID(Integer userID)
   {
       String queryString = "select c from ApplicationTbl c where c.userID = :userID";
       Query query = em.createQuery(queryString);
       query.setParameter(":userID", query);
       Object result = query.getSingleResult();
       ApplicationTbl app = (ApplicationTbl)result;
       Integer appID = app.getAppID();
       return appID; 
   }
   
   public Integer getApplicationStatus(Integer appID)
   {
       String queryString = "select c from ApplicationTbl c where c.appID = :appID";
       Query query = em.createQuery(queryString);
       query.setParameter(":appID", query);
       Object result = query.getSingleResult();
       ApplicationTbl app = (ApplicationTbl)result;
       Integer status = app.getAppStatus();
       return status;
   }
   
   
}
