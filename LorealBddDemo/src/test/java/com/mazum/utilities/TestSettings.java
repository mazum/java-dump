package com.mazum.utilities;

import java.io.InputStream;
import java.util.Properties;

public class TestSettings {

    public static Properties constantsProp = new Properties();
    public static TestSettings _instance;

    public static TestSettings getInstance(){
        if (_instance == null){
            _instance = new TestSettings();
        }
        return _instance;
    }

    public void loadConstantsProperties(){
        System.out.println("LOADING CONSTANTS PROPS");
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("com/mazum/properties/constants.properties");
            if(in!=null){
                constantsProp.load(in);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TestSettings(){

        System.out.println("LOADED CONSTANTS PROPERTIES");
        loadConstantsProperties();
    }

    public Properties getConstantsProp() {
        return constantsProp;
    }


}
