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

    /**
     * Get list of all the applications that match search criteria.
     * @param searchMB search criteria
     * @return list of applicants
     */
    public List<ApplicationTbl> searchApplication(SearchMB searchMB) {
        
        // TODO:
        String queryString = "SELECT a FROM ApplicationTbl a WHERE 1=1";
                  
        if(!searchMB.getEmail().trim().isEmpty()) {
            queryString += String.format(" AND a.personaldataTbl.pDataEmail = '%s' ", searchMB.getEmail());
        }
        if(!searchMB.getCountry().trim().isEmpty()) {
            queryString += String.format(" AND a.personaldataTbl.pDataCountry = '%s' ", searchMB.getCountry());
        }
        
        if(searchMB.getEvaluationStatus() < AppEvaluationStatusEnum.values().length) {
            
        }
        
        if(searchMB.getSubmitStatus() < AppSubmitStatusEnum.values().length) {
            queryString += String.format(" AND a.appStatus = %d ", searchMB.getSubmitStatus());
        }
        
        Query query = em.createQuery(queryString);
        List<ApplicationTbl> result = query.getResultList();
        return result;
    }
}
