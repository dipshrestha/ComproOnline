/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.view;

import edu.mum.comproonline.control.ApplicationControlBean;
import edu.mum.comproonline.model.EnglishProDAO;
import edu.mum.comproonline.model.GreTbl;
import edu.mum.comproonline.model.IeltsTbl;
import edu.mum.comproonline.model.ToeflTbl;
import edu.mum.comproonline.util.JsfUtil;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nazanin
 */
@ManagedBean
@RequestScoped
public class EnglishProMB {

    @EJB
    private ApplicationControlBean EnglishController;
    /**
     * Creates a new instance of EnglishProMB
     */
    
    private int enReadingWritingAbility;
    private int enSpeakingAbility;
    private int enListeningAbility;
    private ToeflTbl toefl ;
    private GreTbl gre;
    private IeltsTbl ielts;
    private boolean ieltsEx;
    private boolean toeflEx;
    private boolean greEx;
  
    
    public EnglishProMB() 
    {
        toefl = new ToeflTbl();
        gre = new GreTbl();
        ielts = new IeltsTbl();
    }

    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
    
    public String getCurrentEmail() {
        return session.getAttribute("susername").toString();
    }
      public boolean isIeltsEx() {
        return ieltsEx;
    }

    public void setIeltsEx(boolean ieltsEx) {
        this.ieltsEx = ieltsEx;
    }

    public boolean isToeflEx() {
        return toeflEx;
    }

    public void setToeflEx(boolean toeflEx) {
        this.toeflEx = toeflEx;
    }

    public boolean isGreEx() {
        return greEx;
    }

    public void setGreEx(boolean greEx) {
        this.greEx = greEx;
    }
    public int getEnReadingWritingAbility() {
        return enReadingWritingAbility;
    }

    public void setEnReadingWritingAbility(int enReadingWritingAbility) {
        this.enReadingWritingAbility = enReadingWritingAbility;
    }

    public int getEnSpeakingAbility() {
        return enSpeakingAbility;
    }

    public void setEnSpeakingAbility(int enSpeakingAbility) {
        this.enSpeakingAbility = enSpeakingAbility;
    }

    public int getEnListeningAbility() {
        return enListeningAbility;
    }

    public void setEnListeningAbility(int enListeningAbility) {
        this.enListeningAbility = enListeningAbility;
    }

    public ToeflTbl getToefl() {
        return toefl;
    }

    public void setToefl(ToeflTbl toefl) {
        this.toefl = toefl;
    }

    public GreTbl getGre() {
        return gre;
    }

    public void setGre(GreTbl gre) {
        this.gre = gre;
    }

    public IeltsTbl getIelts() {
        return ielts;
    }

    public void setIelts(IeltsTbl ielts) {
        this.ielts = ielts;
    }

    
    public void saveEnglishPro() 
     {
        EnglishController.saveEnglishProData(this);
        JsfUtil.addSuccessMessage("Data Saved Successfully");
        
    }
    
}
