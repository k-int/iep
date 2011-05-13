package com.k_int.iep.datamodel

class IEPResource {
 
    IEPProvider owner
    String resourceIdentifier

    static belongsTo = [owner : com.k_int.iep.datamodel.IEPProvider]


    static constraints = {
    }
}
