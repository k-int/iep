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
        if ( stmt.execute("select ID,EMAIL,FEEDBACK_NAME,FEEDBACK_URL,ICON_URL,SOURCE_IDENTIFIER,SOURCE_NAME,RECORD_LICENSE,SHORT_CODE from AGGR_SOURCE") ) {
          ResultSet rs = stmt.getResultSet()
          rs.beforeFirst();
          while ( rs.next() )  {
            println "Process entry ${rs.getString(1)} ${rs.getString(2)} ${rs.getString(3)} ${rs.getString(4)} ${rs.getString(5)} ${rs.getString(6)} ${rs.getString(7)} ${rs.getString(8)} ${rs.getString(9)}"
          }
          println "Done"
          rs.close()
        }

        stmt.close();
        con.close();
      }
      catch( Exception e ) {
        e.printStackTrace();        
      }
    }
}
