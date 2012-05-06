package com.k_int.iep.datamodel

class IEPResourceMessage {

    IEPResource owner
    java.sql.Timestamp messageTimeStamp
    String contactEmail
    String contactName
    String message
    String remoteAddr
    String category
    String status="open"

    static mapping = {
      message type:'text'
    }

    static belongsTo = [owner : com.k_int.iep.datamodel.IEPResource]

    static constraints = {
      status(nullable:true, blank:false)
    }
}
