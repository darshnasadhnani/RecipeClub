package com.recipe.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static Properties properties=null;

    static
    {
        try {
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            properties = new Properties();
            properties.load(in);
        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }

        try {
            Class.forName(properties.getProperty("driverClassName"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException
    {


        return DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));


    }
}
