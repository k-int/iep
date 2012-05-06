package com.k_int.vfis.auth

import com.k_int.vfis.*

class VfisPerson {

	transient springSecurityService

	String username
	String password
  String email
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

  static hasMany = [adminAssociations: PersonOrg]
  static mappedBy = [adminAssociations: "person"]

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<VfisAuthority> getAuthorities() {
		VfisPersonVfisAuthority.findAllByVfisPerson(this).collect { it.vfisAuthority } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
