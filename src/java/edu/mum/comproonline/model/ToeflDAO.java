/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.mum.comproonline.model;

import edu.mum.comproonline.model.AbstractFacade;
import edu.mum.comproonline.model.ToeflTbl;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class ToeflDAO extends AbstractFacade<ToeflTbl>{

   @PersistenceContext(unitName = "ComproOnlinePU")
   private EntityManager em;
   public ToeflDAO()
   {
       super(ToeflTbl.class);
   }
   
   @Override
   protected EntityManager getEntityManager()
   {
       return em;
   }
   
   
   public ToeflTbl getGreData(Integer enID)
   {
       String queryString = "select c from toefl_tbl c where c.enID = :enID";
       Query query = em.createQuery(queryString);
       query.setParameter(":enID", query);
       Object result = query.getSingleResult();
       return (ToeflTbl)result;
   }

   public void createToefl(ToeflTbl t)
   {
       em.persist(t);
   }
   
    public void updateToefl(ToeflTbl t)
   {
       em.merge(t);
   }
}
