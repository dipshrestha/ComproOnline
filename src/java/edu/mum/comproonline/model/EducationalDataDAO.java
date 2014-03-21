/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.mum.comproonline.model;


import edu.mum.comproonline.model.AbstractFacade;
import edu.mum.comproonline.model.EducationaldataTbl;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class EducationalDataDAO extends AbstractFacade<EducationaldataTbl>{

   @PersistenceContext(unitName = "ComproOnlinePU")
   private EntityManager em;
   public EducationalDataDAO()
   {
       super(EducationaldataTbl.class);
   }
   
   @Override
   protected EntityManager getEntityManager()
   {
       return em;
   }
   
   public Integer getEducationID(Integer appID)
   {
       String queryString = "select c from ApplicationTbl c where c.appID=:appID";
       Query query = em.createQuery(queryString);
       query.setParameter(":appID", query);
       Object result = query.getSingleResult();
       EducationaldataTbl edu = (EducationaldataTbl)result;
       Integer eduID = edu.getEdID();
       return eduID; 
   }
   
   
   public void saveEducationalData(EducationaldataTbl educationalData) {
        if( (educationalData.getEdID()!= null) && (em.find(EnglishproTbl.class, educationalData.getEdID()) != null)) {
            em.merge(educationalData);
        }else {
            em.persist(educationalData);
        }
    }
   
}
