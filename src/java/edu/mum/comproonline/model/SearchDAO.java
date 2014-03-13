/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.model;

import edu.mum.comproonline.view.SearchMB;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dipesh
 */
@Stateless
public class SearchDAO extends AbstractFacade<ApplicationTbl> {

    @PersistenceContext(unitName = "ComproOnlinePU")
    private EntityManager em;

    public SearchDAO() {
        super(ApplicationTbl.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<ApplicationTbl> searchApplication(SearchMB searchMB) {
        
        // TODO:
        String queryString = "select a from ApplicationTbl a where 1=1";
        Query query = em.createQuery(queryString);
        Object result = query.getSingleResult();
        
        
        if(!searchMB.getEmail().isEmpty()) {
            queryString += " AND " + "x";
        }
        if(!searchMB.getCountry().isEmpty()) {
            queryString += " AND ";
        }
        if(searchMB.getEvaluationStatus() >= AppEvaluationStatusEnum.values().length) {
            
        }else {
            
        }
        
        if(searchMB.getSubmitStatus() >= AppSubmitStatusEnum.values().length) {
            
        }else {
            
        }
        return null;
    }
}
