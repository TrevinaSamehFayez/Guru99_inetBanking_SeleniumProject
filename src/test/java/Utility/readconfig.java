package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {
    Properties pro;
    public readconfig()
    {
        File src = new File("./Configuration/Config.properties");
        try {
            FileInputStream file = new FileInputStream(src);
            pro = new Properties();
            pro.load(file);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }
    public String getAppUrl(){
        String url = pro.getProperty("baseurl");
        return url;
    }

    public String getUsername(){
        String user = pro.getProperty("username");
        return user;
    }

    public String getPassword(){
        String pass = pro.getProperty("password");
        return pass;
    }

}
