package com.k_int.iep.services

import java.sql.*

class DppSyncService {

    static transactional = true

    def serviceMethod() {
    }

    def syncWithDpp(String appid,
                    String driver,
                    String jdbc_connect_string,
                    String user,
                    String pass) {
      println "Attempt direct MySQL connection with ${jdbc_connect_string}"
      try {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_connect_string,user,pass);
        println "Connected"
        Statement stmt = con.createStatement();
        stmt.close();
        con.close();
      }
      catch( Exception e ) {
        e.printStackTrace();        
      }
    }
}
