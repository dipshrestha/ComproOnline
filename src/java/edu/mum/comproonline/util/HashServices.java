/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.util;

/**
 *
 * @author Ethiopia
 */
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashServices {

    private String passWord;
    private MessageDigest md;

    public HashServices() {

    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public HashServices(String passWord) {

        this.passWord = passWord;
    }

    public String getMessageDigest() {
        byte[] passwordHash = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(this.passWord.getBytes(), 0, this.passWord.length());
            passwordHash = md.digest();

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (new BigInteger(1, passwordHash)).toString(16);

    }

}
