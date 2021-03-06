/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.control;

import edu.mum.comproonline.model.AppEvaluationStatusEnum;
import edu.mum.comproonline.model.ApplicationTbl;
import edu.mum.comproonline.model.EnglishproTbl;
import edu.mum.comproonline.model.ProfessionalexpTbl;
import edu.mum.comproonline.model.ToeflTbl;
import javax.ejb.Stateless;

/**
 *
 * @author dipesh
 */
@Stateless
public class EvaluationControlBean {

    ApplicationTbl application = null;

    public ApplicationTbl getApplication() {
        return application;
    }

    public void setApplication(ApplicationTbl application) {
        this.application = application;
    }
    
    public EvaluationControlBean(ApplicationTbl application) {
        this.application = application;
    }

    public EvaluationControlBean() {
        this.application = new ApplicationTbl();
    }
    
    /**
     * Get evaluation for the application
     * @return evaluation for the application
     */
    public int getEvaluation() {
        int totalScore = getTotalScore();
        if(totalScore <100){
            return AppEvaluationStatusEnum.REJECTED.ordinal();
        }else if(totalScore > 150) {
            return AppEvaluationStatusEnum.ACCEPTED.ordinal();    
        }
        return AppEvaluationStatusEnum.UNDECIDED.ordinal();
    }
    
    public int getTotalScore() {
        int total = getEnglishScore()+ getEducationalScore() + getProfessionalScore();
        return total;
    }
    
    public int getEducationalScore() {
        int score = 0;
        
        score += getDegreeScore();
        score += getSubjectScore();
        score += getGradeScore();
        
        return score;
    }
    
    
    public int getDegreeScore() {
        return -1;
    }
    
    public int getSubjectScore() {
        return -1;
    }
    
    public int getGradeScore() {
        return -1;
    }
    
    public int getProfessionalScore() {
        
        int score = 0;
        score += getEmploymentDurationScore();
        score += getEmploymentTypeScore();
        
        return score;
    }
    
    public int getEmploymentDurationScore() {
        ProfessionalexpTbl professionalexp = application.getProfessionalexpTbl();
        if(professionalexp == null){
            return 0;
        }
        
        int score = 0;
        // TODO:
        int duration = 0;
        professionalexp.getPExStartDate();
        professionalexp.getPExEndDate();
        
        if(duration < 12) {
            score += 10;
        }else if(duration < 36) {
            score += 20;
        }else if (duration < 60) {
            score += 30;
        }else if( duration >= 60) {
            score += 50;
        }
                
        return -1;
    }
    
    public int getEmploymentTypeScore() {
        ProfessionalexpTbl professionalexp = application.getProfessionalexpTbl();
        if(professionalexp == null){
            return 0;
        }
        int score = 0;
        int empType = 0;
        if(empType == 0) {
            score += 20;
        }else if (empType == 1) {
            score += 50;
        }
        
        return score;
    }
    
    public int getEnglishScore() {
        int score = 0;    
        
        score += getEnglishAbilityScore();
        
        score += getToeflScore();        
        score += getGreScore();
        score += getIeltsScore();
        
        return score;
    }
    
    public int getEnglishAbilityScore() {
        int score = 0;
                
        score += getReadWriteScore();
        score += getListeningScore();
        score += getSpeakingScore();
        
        return score;
    }
    
    public int getReadWriteScore() {
        EnglishproTbl englishPro = application.getEnglishproTbl();
        if((englishPro == null) || (englishPro.getEnReadingWritingAbility() == null)) {
            return 0;
        }
        int score = englishPro.getEnReadingWritingAbility() * 2;
        return score;
    }
    
    public int getListeningScore() {
        EnglishproTbl englishPro = application.getEnglishproTbl();
        if((englishPro == null) || (englishPro.getEnListeningAbility() == null)) {
            return 0;
        }
        int score = englishPro.getEnListeningAbility()* 2;
        return score;
    }
    
    public int getSpeakingScore() {
        EnglishproTbl englishPro = application.getEnglishproTbl();
        if((englishPro == null) || (englishPro.getEnSpeakingAbility() == null) ) {
            return 0;
        }
        int score = englishPro.getEnSpeakingAbility()* 2;
        return score;
    }
    
    public int getToeflScore() {
        EnglishproTbl englishPro = application.getEnglishproTbl();
        if(englishPro == null) {
            return 0;
        }
        
        int score = 0;
        ToeflTbl toefl = englishPro.getToeflTbl();
        if((toefl == null) || (toefl.getTScore() == null)) {
            return 0;
        }
        
        if( toefl.getTScore() < 80 ) {
            score += 10;
        }else if(toefl.getTScore() < 100) {
            score += 20;
        }else if(toefl.getTScore() <= 120) {
            score += 30;
        }
        
        return score;
    }
    
    public int getGreScore() {
        EnglishproTbl englishPro = application.getEnglishproTbl();
        if( (englishPro == null) || (englishPro.getGreTbl() == null)) {
            return 0;
        }
        int score = 20;
        return score;
    }
    
    public int getIeltsScore() {
        EnglishproTbl englishPro = application.getEnglishproTbl();
        if( (englishPro == null) || (englishPro.getIeltsTbl()== null)) {
            return 0;
        }
        int score = 20;
        return score;
    }
}
