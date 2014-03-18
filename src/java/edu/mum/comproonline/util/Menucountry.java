/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.comproonline.util;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Nazanin
 */
public class Menucountry {

    private ArrayList<String> countries;
    File countryFile = null;
    
    public Menucountry(String filePath)
    {
        this.countryFile = new File(filePath);
        countries = new ArrayList<String>();
    }
    
    /**
     * @exception IOException,FileNotFoundException
     * 
     */
    private void readCountries()
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader(countryFile));
            String line;
            while ((line = br.readLine()) != null)
            {
                countries.add(line);
            }
        }
        catch(FileNotFoundException e2)
        {
            e2.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }

    public ArrayList<String> getCountries()
    {
        readCountries();
        return countries;
    }
}
