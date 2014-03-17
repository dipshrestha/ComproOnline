/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.model;

import edu.mum.comproonline.model.AbstractFacade;
import edu.mum.comproonline.model.GreTbl;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class GreDAO extends AbstractFacade<GreTbl>{

   @PersistenceContext(unitName = "ComproOnlinePU")
   private EntityManager em;
   public GreDAO()
   {
       super(GreTbl.class);
   }
   
   @Override
   protected EntityManager getEntityManager()
   {
       return em;
   }
   
   
   public GreTbl getGreData(Integer enID)
   {
       String queryString = "select c from gre_tbl c where c.enID = :enID";
       Query query = em.createQuery(queryString);
       query.setParameter(":enID", query);
       Object result = query.getSingleResult();
       return (GreTbl)result;
     
   }

   public void createGre(GreTbl gre)
   {
       em.persist(gre);
   }
   
   public void updateGre(GreTbl gre)
   {
       em.merge(gre);
   }
}
