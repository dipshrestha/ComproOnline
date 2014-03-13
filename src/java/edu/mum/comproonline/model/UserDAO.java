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
public class UserDAO {

    @PersistenceContext(unitName = "ComproOnlinePU")
    private EntityManager em;
    //private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SWEMYPRJPU");
    //private EntityManager em = emf.createEntityManager();

    public void create(UserTbl user) throws Exception {
        //em.getTransaction().begin();
        em.persist(user);
        //em.getTransaction().commit();
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
}
