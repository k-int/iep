package com.k_int.iep.datamodel

class RefdataCategory {

  String code
  String desc

  static mapping = {
         id column:'rec_id'
    version column:'rec_version'
       desc column:'rec_description', index:'rdc_description_idx'
  }

  static constraints = {
  }
}
