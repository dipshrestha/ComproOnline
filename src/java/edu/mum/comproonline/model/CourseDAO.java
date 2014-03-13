/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.model;


import edu.mum.comproonline.model.AbstractFacade;
import edu.mum.comproonline.model.CoursesTbl;
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
public class CourseDAO extends AbstractFacade<CoursesTbl> {

    @PersistenceContext(unitName = "ComproOnlinePU")
    private EntityManager em;
    
    public CourseDAO()
    {
        super(CoursesTbl.class);
    }
    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    
    public List<CoursesTbl> getAllCoursesJPQL(Integer instituteID)
    {
        String queryString = "select c from courses_tbl c where c.instituteID=:instituteID";
        Query query = em.createQuery(queryString);
        query.setParameter(":instituteID", query);
        List<CoursesTbl> courses = query.getResultList();
        return courses;  
    }
}
