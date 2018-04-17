package com.example.augusto.firetruckassistant;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import net.sourceforge.jtds.jdbc.*;

/**
 * Created by augus on 2018-04-11.
 */

public class FireDB {

    public void query2()
    {
        Log.d("TEST"," MySQL Connect Example.");
        Connection conn = null;
        try {
            String driver = "net.sourceforge.jtds.jdbc.Driver";
            Class.forName(driver).newInstance();
//test = com.microsoft.sqlserver.jdbc.SQLServerDriver.class;
            String connString = "jdbc:jtds:sqlserver://192.168.43.160:1434/FireDB;encrypt=false;user=myuser;password=11111111;instance=SQLEXPRESS;";
            String username = "myuser";
            String password = "11111111";
            Log.d("TEST", "Before connection");
            conn = DriverManager.getConnection(connString, username, password);
            Log.w("TEST","Connection open");
            Statement stmt = conn.createStatement();
            ResultSet reset = stmt.executeQuery("select * from Fire");
//Print the data to the console
            while(reset.next()){
                Log.d("Data:",reset.getString(0))
                ;
                Log.d("Data:",reset.getString(1));
                Log.d("Data:",reset.getString(2));
                Log.d("Data:",reset.getString(3));
//              Log.w("Data",reset.getString(2));
            }
            conn.close();
        } catch (Exception e)
        {
            Log.w("Error connection","" + e.getMessage());
        }
    }

}
