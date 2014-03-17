/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.model;

import javax.ejb.Stateless;
import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class EnglishProDAO extends AbstractFacade<EnglishproTbl> {
   
    
    
    @PersistenceUnit(unitName = "ComproOnlinePU")
    private EntityManager em;
    
     @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    
    public EnglishProDAO()
    {
        super(EnglishproTbl.class);
    }
    
   
    
    public EnglishproTbl getEnglishProData(Integer appID)
    {
        String queryString = "select c from EnglishproTbl c where c.appID=:appID";
        Query query = em.createQuery(queryString);
        query.setParameter(":appID", query);
        Object result = query.getSingleResult();
        return (EnglishproTbl)result;
        
    }
    
    public void createEnglish(EnglishproTbl en)
    {
        em.persist(en);
    }
    
    public void updateEnglish(EnglishproTbl en)
    {
        em.merge(en);
    }
}
