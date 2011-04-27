package com.k_int.ifs

import org.apache.shiro.SecurityUtils

class HomeController {

    def index = { 
      println "Home"
      def subject = SecurityUtils.getSubject()
      println "Hello ${subject.principal} - auth? ${subject.authenticated}"
    }
}
