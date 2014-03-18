/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.model;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author User
 */
@Stateless
//public class UserDAO {
//
//    @PersistenceContext(unitName = "ComproOnlinePU")
//    private EntityManager em;
//    //private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SWEMYPRJPU");
//    //private EntityManager em = emf.createEntityManager();
//
//    public void create(UserTbl user) throws Exception {
//        //em.getTransaction().begin();
//        em.persist(user);
//        //em.getTransaction().commit();
//    }

public class UserDAO extends AbstractFacade<UserTbl>{

   @PersistenceContext(unitName = "ComproOnlinePU")
   private EntityManager em;
   public UserDAO()
   {
       super(UserTbl.class);
   }
   
   @Override
   protected EntityManager getEntityManager()
   {
       return em;
   }
   

    public int countEmails(String userEmail) {

        TypedQuery<UserTbl> query
                = em.createQuery("SELECT  a FROM UserTbl a WHERE a.userEmail = '" + userEmail + "'", UserTbl.class);
        List<UserTbl> results = query.getResultList();
        return results.size();
        
        
    }
    /**
     * This method gets the userID by email
     * @param userEmail
     * @return userID
     * @author Nazanin
     */
    public Integer getUserIDByEmail(String userEmail)
    {
        String queryString = "select c from user_tbl c where c.userEmail=:userEmail";
        Query query = em.createQuery(queryString);
        query.setParameter("userEmail", query);
        UserTbl user =(UserTbl) query.getSingleResult();
        Integer userID = user.getUserID();
        return userID;

    }
    
        public void edit(UserTbl entity) {
        em.merge(entity);
    }

    /**
     * returns list of UserTbl,but in this case it returns only one UserTbl
     * object
     * @param userEmail
     * @return 
     */
    public List<UserTbl> getUserTbl(String userEmail){
    TypedQuery<UserTbl> query
           = em.createQuery("SELECT  a FROM UserTbl a WHERE a.userEmail = '" + userEmail + "'", UserTbl.class);
        List<UserTbl> results = query.getResultList();
        //if(results==null){return null;}
        return results ;
    }
    
    /**
     * @author Dipesh
     * @param userId
     * @return 
     */
    public UserTbl getUserById(int userId)
    {
        Query query = em.createQuery("select c FROM UserTbl c where c.userID = :userId");
        query.setParameter("userId", userId);
        UserTbl user =(UserTbl) query.getSingleResult();
        return user;
    }    
}
