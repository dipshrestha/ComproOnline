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

    public UserTbl findApplicantByEmailAddr(String username, String password) {

        try {
            Query userNameQuery = em.createNamedQuery("UserTbl.findByUserEmail");
            userNameQuery.setParameter("userEmail", username);
            // userNameQuery.setParameter("password", password);
            UserTbl founduser = (UserTbl) userNameQuery.getSingleResult();

            return founduser;
        } catch (NoResultException e) {
            return null;
        }

    }

}
