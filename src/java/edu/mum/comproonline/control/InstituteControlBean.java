/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.control;


import javax.ejb.Stateless;
import edu.mum.comproonline.model.InstituteTbl;
import edu.mum.comproonline.model.AbstractFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nazanin
 */
@Stateless
public class InstituteControlBean extends AbstractFacade<InstituteTbl> {

    @PersistenceContext(unitName = "ComproOnlinePU")
    private EntityManager em;
    
    public InstituteControlBean()
    {
        super(InstituteTbl.class);
    }
    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    
    public List<InstituteTbl> getAllInstituesJPQL(Integer enID)
    {
        String queryString = "select c from institute_tbl c where c.enID=:enID ";
        Query query = em.createQuery(queryString);
        query.setParameter(":enID", query);
        List<InstituteTbl> institutes = query.getResultList();
        return institutes;  
    }
}
