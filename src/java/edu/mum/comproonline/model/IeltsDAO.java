/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.mum.comproonline.model;

import edu.mum.comproonline.model.AbstractFacade;
import edu.mum.comproonline.model.IeltsTbl;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class IeltsDAO extends AbstractFacade<IeltsTbl>{

   @PersistenceContext(unitName = "ComproPU")
   private EntityManager em;
   public IeltsDAO()
   {
       super(IeltsTbl.class);
   }
   
   @Override
   protected EntityManager getEntityManager()
   {
       return em;
   }
   
   
   public IeltsTbl getGreData(Integer enID)
   {
       String queryString = "select c from ielts_tbl c where c.enID = :enID";
       Query query = em.createQuery(queryString);
       query.setParameter(":enID", query);
       Object result = query.getSingleResult();
       return (IeltsTbl)result;
     
   }

   
}
