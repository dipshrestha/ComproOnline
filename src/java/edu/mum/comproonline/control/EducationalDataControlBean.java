/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package edu.mum.comproonline.control;

import edu.mum.comproonline.model.AbstractFacade;
import javax.ejb.Stateless;
import edu.mum.comproonline.model.EducationaldataTbl;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class EducationalDataControlBean extends AbstractFacade<EducationaldataTbl>{

   @PersistenceContext(unitName = "ComproOnlinePU")
   private EntityManager em;
   public EducationalDataControlBean()
   {
       super(EducationaldataTbl.class);
   }
   
   @Override
   protected EntityManager getEntityManager()
   {
       return em;
   }
   
   
   public EducationaldataTbl getEducationalData(Integer appID)
   {
       String queryString = "select c from educationaldata_tbl c where c.appID = :appID";
       Query query = em.createQuery(queryString);
       query.setParameter(":appID", query);
       Object result = query.getSingleResult();
       return (EducationaldataTbl)result;
     
   }
   public Integer getEducationID(Integer appID)
   {
       String queryString = "select c from educationaldata_tbl c where c.appID = :appID";
       Query query = em.createQuery(queryString);
       query.setParameter(":appID", query);
       Object result = query.getSingleResult();
       EducationaldataTbl education = (EducationaldataTbl)result;
       Integer educationID = education.getEdID();
       return educationID; 
   }
           
   
   
}
