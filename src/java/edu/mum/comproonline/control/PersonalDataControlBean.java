/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.control;


import edu.mum.comproonline.model.AbstractFacade;
import javax.ejb.Stateless;
import edu.mum.comproonline.model.PersonaldataTbl;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class PersonalDataControlBean extends AbstractFacade<PersonaldataTbl>{

   @PersistenceContext(unitName = "ComproOnlinePU")
   private EntityManager em;
   public PersonalDataControlBean()
   {
       super(PersonaldataTbl.class);
   }
   
   @Override
   protected EntityManager getEntityManager()
   {
   return em;
   }
   
   
   public PersonaldataTbl getPersonalData(Integer appID)
   {
       String queryString = "select c from PersonaldataTbl c where c.appID = :appID";
       Query query = em.createQuery(queryString);
       query.setParameter(":appID", query);
       Object result = query.getSingleResult();
       return (PersonaldataTbl)result;
     
   }
   
   
}
