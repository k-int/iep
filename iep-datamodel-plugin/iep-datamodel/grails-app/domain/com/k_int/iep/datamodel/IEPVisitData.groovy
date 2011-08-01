package com.k_int.iep.datamodel

class IEPVisitData {

  Date eventDate = new Date()
  String uri
  String agent
  String referrer
  String ip

  static constraints = {
    referrer(nullable:true)
  }
}
