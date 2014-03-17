/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.control;

import edu.mum.comproonline.model.AppSubmitStatusEnum;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.CoursesTbl;
import edu.mum.comproonline.model.EducationaldataTbl;
import edu.mum.comproonline.model.EnglishproTbl;
import edu.mum.comproonline.model.GreTbl;
import edu.mum.comproonline.model.InstituteTbl;
import edu.mum.comproonline.model.PersonaldataTbl;
import edu.mum.comproonline.model.ProfessionalexpTbl;
import edu.mum.comproonline.model.UserDAO;
import edu.mum.comproonline.model.UserEnum;
import edu.mum.comproonline.model.UserTbl;
import edu.mum.comproonline.util.HashServices;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dipesh
 */
@Stateless
public class LoadDataControlBean {

    @PersistenceContext(unitName = "ComproOnlinePU")
    private EntityManager em;

    /**
     * Creates a new instance of LoadDataControlBean
     */
    public LoadDataControlBean() {
        
    }

    public void loadData() {

        // ------------------------------------------ //
        //         Adding the User Data
        // ------------------------------------------ //
        // Create Applicant with userID: applicant@applicant.com and password
        // applicant@applicant.com
        UserTbl applicant = new UserTbl();
        applicant.setUserEmail("applicant@applicant.com");
        applicant.setUserFirstName("applicant");
        applicant.setUserID(100);
        applicant.setUserLastLoginDate(null);
        applicant.setUserCreationDate(Calendar.getInstance().getTime());
        applicant.setUserLastName("applicant");
        applicant.setUserPassword(new HashServices("applicant").getMessageDigest());
        applicant.setUserRole(UserEnum.APPLICANT.ordinal());
        applicant.setUserStatus(1); // 0: inactive, 1: active
        em.persist(applicant);
        
        // Create Applicant with userID: staff@staff.com and password
        // staff@staff.com
        UserTbl staff = new UserTbl();
        staff.setUserEmail("staff@staff.com");
        staff.setUserFirstName("staff");
        applicant.setUserID(101);
        staff.setUserLastLoginDate(null);
        staff.setUserCreationDate(Calendar.getInstance().getTime());
        staff.setUserLastName("staff");
        staff.setUserPassword(new HashServices("staff").getMessageDigest());
        staff.setUserRole(UserEnum.STAFF.ordinal());
        staff.setUserStatus(1); // 0: inactive, 1: active
        em.persist(staff);
        
        // Create Applicant with userID: admin@admin.com and password
        // admin@admin.com
        UserTbl admin = new UserTbl();
        admin.setUserEmail("admin@admin.com");
        admin.setUserFirstName("admin");
        applicant.setUserID(102);
        admin.setUserLastLoginDate(null);
        admin.setUserCreationDate(Calendar.getInstance().getTime());
        admin.setUserLastName("admin");
        admin.setUserPassword(new HashServices("admin").getMessageDigest());
        admin.setUserRole(UserEnum.ADMIN.ordinal());
        admin.setUserStatus(1); // 0: inactive, 1: active
        em.persist(admin);
        
        
        // ------------------------------------------ //
        //         Adding the Professiona Data
        // ------------------------------------------ //
        ProfessionalexpTbl professionalexp = new ProfessionalexpTbl();
        professionalexp.setPExID(100);
        professionalexp.setPExCity("kathmandu");
        professionalexp.setPExCompanyName("BSoftNepal");
        professionalexp.setPExCountry("Nepal");
        professionalexp.setPExDataStructureTime(100);
        professionalexp.setPExDbAdminTime(100);
        // 0: Full-time paid, 1: Part-time paid
        professionalexp.setPExEmploymentType("Full-time paid");
        professionalexp.setPExEndDate("01/01/2013");
        professionalexp.setPExManagementTime(100);
        professionalexp.setPExNetworkingTime(100);
        professionalexp.setPExOtherTime(100);
        professionalexp.setPExPosition("Manager");
        professionalexp.setPExProgrammingTime(100);
        professionalexp.setPExStartDate("01/01/2012");
        professionalexp.setPExTrainingTime(100);        
        em.persist(professionalexp);
        
        // ------------------------------------------ //
        //         Adding personal data
        // ------------------------------------------ //
        PersonaldataTbl personaldata = new PersonaldataTbl();
        
        personaldata.setPDataAddressLine1("1000 N 4TH ST");
        personaldata.setPDataAddressLine2("MR#594");
        personaldata.setPDataCity("Fairfield");
        personaldata.setPDataCountry("USA");
        personaldata.setPDataEmail("dipshrestha@gmail.com");
        personaldata.setPDataFirstName("Dipesh");
        personaldata.setPDataGender("Male");
        personaldata.setPDataHomeCountry("Nepal");
        personaldata.setPDataHomePhone("6414510356");
        personaldata.setPDataID(100);
        personaldata.setPDataLastName("Shrestha");
        personaldata.setPDataMiddleName("Lal");
        personaldata.setPDataMobilePhone("6414510000");
        personaldata.setPDataSkypeID("dipshrestha");
        personaldata.setPDataState("Iowa");
        personaldata.setPDataVisaStatus("Something");
        personaldata.setPDataZipCode("52557");
        em.persist(personaldata);
                
        
        // ------------------------------------------ //
        //         Adding EnglishProf data
        // ------------------------------------------ //
        GreTbl gre = new GreTbl();
        gre.setGAnalyticalPercentile(10);
        gre.setGAnalyticalScore(10);
        gre.setGID(100);
        gre.setGQuantitativePercentile(100);
        gre.setGQuantitativeScore(100);
        gre.setGVerbalPercentile(100);
        gre.setGYearTaken("1994");
        em.persist(gre);
        
        EnglishproTbl englishPro = new EnglishproTbl();
        englishPro.setEnID(100);
        englishPro.setEnListeningAbility(1);
        englishPro.setEnReadingWritingAbility(1);
        englishPro.setEnSpeakingAbility(2);
        englishPro.setGreTbl(gre);
        englishPro.setIeltsTbl(null);   // WRITING NULL WORKS!!
        englishPro.setToeflTbl(null);   // WRITING NULL WORKS!!
        em.persist(englishPro);
        
        
        // ------------------------------------------ //
        //         Adding Education data
        // ------------------------------------------ // 
        EducationaldataTbl educationaldata = new EducationaldataTbl();
        //educationaldata.setEdID(100);
        //List<InstituteTbl> instituteList = new ArrayList<>();
        //instituteList.add(institute1);
        //educationaldata.setInstituteTblCollection( instituteList);
        em.persist(educationaldata);
        
        InstituteTbl institute1 = new InstituteTbl();
        //institute1.setCoursesTblCollection(null);
        institute1.setInstituteArea("kathmandu");
        institute1.setInstituteCity("kathmandu");
        institute1.setInstituteCounty("Nepal");
        institute1.setInstituteDegree("Bachelor");
        institute1.setInstituteDegreeStatus("Completed");
        institute1.setInstituteEndDate("01/01/2014");
        institute1.setInstituteFinalGPA("4");
        institute1.setInstituteGradingScale("4");
        institute1.setInstituteID(100);
        institute1.setInstituteName("Tribhuwan University");
        institute1.setInstituteStartDate("01/01/2013");
        institute1.setInstituteSubject("Mathematics");
        institute1.setInstituteID(educationaldata.getEdID());
        em.persist(institute1);
        
        CoursesTbl course = new CoursesTbl();
        course.setCourseGrade("4.0");
        course.setCourseID(100);
        course.setCourseInsID(institute1);
        course.setCourseTitle("Algorithm");
        course.setCourseType("MyType");
        em.persist(course);       
        
        
        InstituteTbl institute2 = new InstituteTbl();
        institute2.setCoursesTblCollection(null);
        institute2.setInstituteArea("Hokkaido");
        institute2.setInstituteCity("Sapporo");
        institute2.setInstituteCounty("Japan");
        institute2.setInstituteDegree("Research");
        institute2.setInstituteDegreeStatus("Completed");
        institute2.setInstituteEndDate("01/01/2014");
        institute2.setInstituteFinalGPA("4");
        institute2.setInstituteGradingScale("4");
        institute2.setInstituteID(100);
        institute2.setInstituteName("WAKHOK University");
        institute2.setInstituteStartDate("01/01/2013");
        institute2.setInstituteSubject("Research");
        institute2.setInstituteID(educationaldata.getEdID());
        em.persist(institute2);
        
        // ------------------------------------------ //
        //         Saving the application
        // ------------------------------------------ //
        ApplicationTbl application = new ApplicationTbl();
        application.setAppStatus(AppSubmitStatusEnum.SUBMITTED.ordinal());
        application.setAppID(100);
        application.setAppUserID(applicant);
        
        application.setEnglishproTbl(englishPro);
        application.setProfessionalexpTbl(professionalexp);        
        application.setPersonaldataTbl(personaldata);
        application.setEducationaldataTbl(educationaldata);
        
        em.persist(application);
        
        // TEST
        //Query q = em.createQuery("SELECT a FROM ApplicationTbl a WHERE a.appID=100", ApplicationTbl.class);
        //ApplicationTbl result = (ApplicationTbl)q.getSingleResult();
        
    }

}
