package com.k_int.ifs

import org.apache.shiro.SecurityUtils
import com.k_int.iep.datamodel.*

class HomeController {

    def index = { 
      def result = [:]
      println "Home"
      // def subject = SecurityUtils.getSubject()
      // println "Hello ${subject.principal} - auth? ${subject.authenticated} - injected: ${authenticatedUser}"
      println "User: ${authenticatedUser.username}"
      result.user = authenticatedUser


      println "Work out the authorities and records this user has been granted admin permission over."
      result.userAuthorities = []
      com.k_int.iep.datamodel.IEPProvider.findAll().each { prov ->
        // println "Adding ${prov}"
        result.userAuthorities.add(prov)
      } 

      // println "done"
      result
    }
}
