package com.OrangeHRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties prop;

    public ReadConfig(){
        File src = new File("src/Configurations/Config.properties");
        try{
            FileInputStream fis = new FileInputStream(src);
            prop =new Properties();
            prop.load(fis);
        }catch (Exception e){
            System.out.println("Exception caught"+e.getMessage());
        }
    }

    public String getURL(){
        return prop.getProperty("applicationURL");
    }



}
