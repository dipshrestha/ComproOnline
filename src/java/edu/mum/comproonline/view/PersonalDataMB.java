/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.view;

import edu.mum.comproonline.control.ApplicationControlBean;
import edu.mum.comproonline.model.ApplicationDAO;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.LoginDAO;
import edu.mum.comproonline.model.PersonaldataTbl;
import edu.mum.comproonline.model.UserDAO;
import edu.mum.comproonline.model.UserTbl;
import edu.mum.comproonline.util.JsfUtil;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import edu.mum.comproonline.util.Menucountry;
import javax.annotation.PostConstruct;

/**
 *
 * @author Nazanin
 */
@ManagedBean
@RequestScoped
public class PersonalDataMB {

    @EJB
    ApplicationDAO applicationDAO;
    @EJB
    UserDAO userDAO;    
    @EJB
    LoginDAO loginDAO;
    
    private ArrayList<String> allCountries = new ArrayList<>();
    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

    private ApplicationTbl application;
    private PersonaldataTbl personalData;
    private UserTbl user;

    public PersonaldataTbl getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonaldataTbl personalData) {
        this.personalData = personalData;
    }
    
    public ArrayList<String> getAllCountries() {
        return allCountries;
    }

    public PersonalDataMB() {
        String filePath = facesContext.getExternalContext().getRealPath("/resources/files/countryList.txt");
        Menucountry countryUtil = new Menucountry(filePath);
        allCountries = countryUtil.getCountries();
    }
    
    /**
     * Load the PersonalData of Current Logged applicant
     */
    @PostConstruct
    public void init() {
        String email = session.getAttribute("susername").toString();        
        this.user = loginDAO.findApplicantByEmailAddr(email);
 
        this.application =  applicationDAO.getApplication(user.getUserID());
        if(application != null) {
            this.personalData = application.getPersonaldataTbl();
        }else {
            this.personalData = new PersonaldataTbl();
            this.application = new ApplicationTbl();
        }
    }
    
    /**
     * Save the current PersonalData
     */
    public void save() {
        // BUG: creating two rows of PersonalData when application is created for first time.
        this.applicationDAO.savePersonalData(this.personalData);
        this.application.setPersonaldataTbl(personalData);
        this.application.setAppUserID(user);
        this.applicationDAO.saveApplication(this.application);
    }
    
}

//public class PersonalDataMB {
//
//   @EJB
//   ApplicationControlBean applicationController;
//   private ArrayList<String> allCountries = new ArrayList<String>();
//   
//    
//
//    public ArrayList<String> getAllCountries() {
//        return allCountries;
//    }
//  
//    public PersonalDataMB() 
//    {
//       String filePath = facesContext.getExternalContext().getRealPath("/resources/files/countryList.txt");
//       Menucountry countryUtil = new Menucountry(filePath);
//       allCountries = countryUtil.getCountries();
//    }
//    
//    private String firstName;
//    private String middleName;
//    private String lastName;
//    private String gender;
//    private String homeCounty;
//    private String country;
//    private String city;
//    private String state;
//    private String addressLine1;
//    private String addressLine2;
//    private String zipCode;
//    private String homePhone;
//    private String mobilePhone;
//    private String skypeId;
//    @Pattern(regexp = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[a-zA-Z]{2,4}$", message = "Invalid email format")
//    private String email;
//    private String visaStatus;
//
//    
//    FacesContext facesContext = FacesContext.getCurrentInstance();
//    HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
//
//    
//    public String getCurrentEmail() 
//    {
//        return session.getAttribute("susername").toString();
//    }
//    
//   
//
//   
//
//    public void setAllCountries(ArrayList<String> allCountries) {
//        this.allCountries = allCountries;
//    }
//   
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public void setHomeCounty(String homeCounty) {
//        this.homeCounty = homeCounty;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public void setAddressLine1(String addressLine1) {
//        this.addressLine1 = addressLine1;
//    }
//
//    public void setAddressLine2(String addressLine2) {
//        this.addressLine2 = addressLine2;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public void setHomePhone(String homePhone) {
//        this.homePhone = homePhone;
//    }
//
//    public void setMobilePhone(String mobilePhone) {
//        this.mobilePhone = mobilePhone;
//    }
//
//    public void setSkypeId(String skypeId) {
//        this.skypeId = skypeId;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setVisaStatus(String visaStatus) {
//        this.visaStatus = visaStatus;
//    }
// 
//
//
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public String getHomeCounty() {
//        return homeCounty;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public String getAddressLine1() {
//        return addressLine1;
//    }
//
//    public String getAddressLine2() {
//        return addressLine2;
//    }
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public String getHomePhone() {
//        return homePhone;
//    }
//
//    public String getMobilePhone() {
//        return mobilePhone;
//    }
//
//    public String getSkypeId() {
//        return skypeId;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getVisaStatus() {
//        return visaStatus;
//    }
//   
//    
//    
//     public void savePersonalData() 
//     {
//        JsfUtil.addSuccessMessage(getCurrentEmail());
//        applicationController.savePersonalData(this);
//        JsfUtil.addSuccessMessage("Data Saved Successfully");
//        
//      }
//     public void checkApplication()
//     {
//         applicationController.prepareApplication(this);
//     }
//    
//    
//    
//}
