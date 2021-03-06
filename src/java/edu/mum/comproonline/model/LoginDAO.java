/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.model;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Md. Khan
 */
@Stateless
public class LoginDAO implements Serializable {

    @PersistenceContext(unitName = "ComproOnlinePU")
    private EntityManager em;

    public void setLoginTime(UserTbl user) {
        em.merge(user);
    }

    public UserTbl findApplicantByEmailAddr(String username) {

        try {
            //Query userNameQuery = em.createNamedQuery("UserTbl.findByUserEmail");
            Query userNameQuery = em.createQuery("SELECT u FROM UserTbl u WHERE u.userStatus = 1 AND u.userEmail = :userEmail");
            userNameQuery.setParameter("userEmail", username);
            UserTbl founduser = (UserTbl) userNameQuery.getSingleResult();

            return founduser;
        } catch (NoResultException e) {
            return null;
        }

    }

}
