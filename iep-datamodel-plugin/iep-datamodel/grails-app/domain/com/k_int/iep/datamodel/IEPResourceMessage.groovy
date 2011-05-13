package com.k_int.iep.datamodel

class IEPResourceMessage {

    IEPResource owner
    Date messageTimeStamp
    String contactEmail
    String contactName
    String contactTel
    String message

    static belongsTo = [owner : com.k_int.iep.datamodel.IEPResource]

    static constraints = {
    }
}
