package com.k_int.iep.services

import java.sql.*
import com.k_int.iep.datamodel.*

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
            String icon_url = rs.getString(5)
            String identifier = rs.getString(6)
            String name = rs.getString(7)
            String email = rs.getString(2)
            String short_code = rs.getString(9)

            if ( ( short_code != null ) && ( identifier != null ) ) {
              def provider = IEPProvider.findByShortCode(short_code)
              if ( provider == null ) { 
                println "Create record for ${name} - ${identifier} / ${short_code}"
                provider = new IEPProvider(identifier:identifier, 
                                           shortCode:short_code, 
                                           name:name,
                                           email:email,
                                           iconURL:icon_url).save(flush:true)
              }
              else {
                println "verified existing record - ${name} - ${identifier} / ${short_code}"
              }            
            }
            else {
              println "Unexpected problem, source record is missing short code. Id should be ${rs.getString(1)}"
            }
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
