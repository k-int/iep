package com.k_int.iep.datamodel

/**
 *  IEPProvider is a record authority / provider. an IEPProvider is an authoritative data source for a particualr set of records.
 */
class IEPProvider {

    String identifier
    String shortCode
    String name
    String office
    String thoroughfare
    String dependentThoroughfare
    String locality
    String dependentLocality
    String region
    String postcode
    String description
    String contactEmail
    String contactTelephone
    String contactFax

    static constraints = {
      identifier(nullable:false,blank:false)
      shortCode(nullable:false,blank:false)
      name(nullable:true,blank:true)
      office(nullable:true,blank:true)
      thoroughfare(nullable:true,blank:true)
      dependentThoroughfare(nullable:true,blank:true)
      locality(nullable:true,blank:true)
      dependentLocality(nullable:true,blank:true)
      region(nullable:true,blank:true)
      postcode(nullable:true,blank:true)
      description(nullable:true,blank:true)
      contactEmail(nullable:true,blank:true)
      contactTelephone(nullable:true,blank:true)
      contactFax(nullable:true,blank:true)
    }

}
