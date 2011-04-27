package com.k_int.ifs

import org.apache.shiro.SecurityUtils
import com.k_int.iep.datamodel.*

class HomeController {

    def index = { 
      println "Home"
      // def subject = SecurityUtils.getSubject()
      // println "Hello ${subject.principal} - auth? ${subject.authenticated} - injected: ${authenticatedUser}"
      println "User: ${authenticatedUser.username}"
    }
}
