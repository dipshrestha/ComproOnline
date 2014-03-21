/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package edu.mum.comproonline.model;


import edu.mum.comproonline.model.AbstractFacade;
import edu.mum.comproonline.model.InstituteTbl;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class InstituteDAO extends AbstractFacade<InstituteTbl> {

    @PersistenceContext(unitName = "ComproOnlinePU")
    private EntityManager em;
    
    public InstituteDAO()
    {
        super(InstituteTbl.class);
    }
    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    
    public List<InstituteTbl> getAllInstitutesJPQL(Integer edID)
    {
        String queryString = "select c from institute_tbl c where c.edID=:edID";
        Query query = em.createQuery(queryString);
        query.setParameter(":edID", query);
        List<InstituteTbl> institutes = query.getResultList();
        return institutes;  
    }
    
    public void saveInstituteData(InstituteTbl instituteData) {
        if( (instituteData.getInstituteID()!= null) && (em.find(InstituteTbl.class, instituteData.getInstituteID()) != null)) {
            em.merge(instituteData);
        }else {
            em.persist(instituteData);
        }
    }    
}

