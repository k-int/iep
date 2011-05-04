package com.k_int.iep.datamodel

class IEPConfigParamDefn {

    String paramNameMessageId
    String paramType

    IEPConfigParamDefn parent

    static constraints = {
      parent(nullable:true,blank:true)
    }

}
