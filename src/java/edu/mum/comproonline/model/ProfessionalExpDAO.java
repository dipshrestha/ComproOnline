/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.mum.comproonline.model;

import edu.mum.comproonline.model.AbstractFacade;
import edu.mum.comproonline.model.ProfessionalexpTbl;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class ProfessionalExpDAO extends AbstractFacade<ProfessionalexpTbl>{

   @PersistenceContext(unitName = "ComproOnlinePU")
   private EntityManager em;
   public ProfessionalExpDAO()
   {
       super(ProfessionalexpTbl.class);
   }
   
   @Override
   protected EntityManager getEntityManager()
   {
       return em;
   }
   
   
   public ProfessionalexpTbl getPersonalData(Integer appID)
   {
       String queryString = "select c from ProfessionalexpTbl c where c.appID = :appID";
       Query query = em.createQuery(queryString);
       query.setParameter(":appID", query);
       Object result = query.getSingleResult();
       return (ProfessionalexpTbl)result;
     
   }
   
   
}
