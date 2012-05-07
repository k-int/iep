package com.k_int.iep.datamodel

class RefdataValue {

  String value
  String sortkey

  static belongsTo = [
    owner:RefdataCategory
  ]

  static mapping = {
         id column:'rdv_id'
    version column:'rdv_version'
      owner column:'rdv_owner', index:'rdv_entry_idx'
      value column:'rdv_value', index:'rdv_entry_idx'
    sortkey column:'rdv_sortkey'
  }

  static constraints = {
    sortkey(nullable:true, blank:true)
  }
}