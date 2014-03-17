/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.model;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class ApplicationDAO extends AbstractFacade<ApplicationTbl> {

    @PersistenceContext(unitName = "ComproOnlinePU")
    private EntityManager em;

    public ApplicationDAO() {
        super(ApplicationTbl.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }



    /**
     * @Author md. Khan Update Application Status
     * @param app
     */
    public void updateStatus(ApplicationTbl app) {

        em.merge(app);
    }

    /**
     * @Author md. Khan
     * @param userID
     * @return
     */
    public ApplicationTbl getApplicationIDForStatus(Integer appID) {

        try {
            Query userNameQuery = em.createNamedQuery("ApplicationTbl.findByAppID");
            userNameQuery.setParameter("appID", appID);
            // userNameQuery.setParameter("password", password);
            ApplicationTbl founduser = (ApplicationTbl) userNameQuery.getSingleResult();

            return founduser;
        } catch (NoResultException e) {
            return null;
        }

    }
     public ApplicationTbl getApplication(Integer userID) {
        String queryString = "select c from ApplicationTbl c where c.appUserID.userID = :userparam";
        Query query = em.createQuery(queryString);
        query.setParameter("userparam", query);
        Object result = query.getSingleResult();
        ApplicationTbl app = (ApplicationTbl) result;
        return app;
    }

    public Integer getApplicationStatus(Integer appID) {
        String queryString = "select c from ApplicationTbl c where c.appID = :appID";
        Query query = em.createQuery(queryString);
        query.setParameter("appID", query);
        Object result = query.getSingleResult();
        ApplicationTbl app = (ApplicationTbl) result;
        Integer status = app.getAppStatus();
        return status;
    }



    public boolean checkPAppID(Integer appID) {
      
           
            String queryString = "select c from PersonaldataTbl c where c.pAppID = :userparam";
            Query query = em.createQuery(queryString);
            query.setParameter("userparam", appID);
            List<ApplicationTbl> result =  query.getResultList();
            if(result.isEmpty())
            {
                return false;
            }
            else
            {
                return true;
            }
    }
    
    public Integer getApplicationID(Integer userID) {
        String queryString = "select c from ApplicationTbl c where c.appUserID.userID = :userparam";
        Query query = em.createQuery(queryString);
        query.setParameter("userparam", userID);
        return query.getFirstResult();
  
    }
    
    
    public ApplicationTbl getApplicationEntity(Integer userID)
    {
            String queryString = "select c from ApplicationTbl c where c.appUserID.userID = :userparam";
            Query query = em.createQuery(queryString);
            query.setParameter("userparam", userID);
           List<ApplicationTbl> result =  query.getResultList();
            return result.get(0);
    }
    
    public boolean checkEnglishID(Integer appID)
    {
        String queryString = "select c from EnglishproTbl c where c.enAppID  = :appIDparam";
        Query query = em.createQuery(queryString);
        query.setParameter("appIDparam", appID);
        List<ApplicationTbl> result = query.getResultList();
        if(result.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
        
    }
    
    public void createApplication(ApplicationTbl app)
    {
        em.persist(app);
    }

    public void updateApplication(ApplicationTbl app)
    {
        em.merge(app);
    }
}
