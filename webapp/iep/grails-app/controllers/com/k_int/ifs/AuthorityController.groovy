package com.k_int.ifs

class AuthorityController {

  def index = { 
    def result = [:]
    println "Home"

    println "User: ${authenticatedUser.username}"
    result.user = authenticatedUser

    // println "done"
    result
  }

  def dashboard = { 
    def result = [:]
    println "Home"

    println "User: ${authenticatedUser.username}"
    result.user = authenticatedUser

    // println "done"
    result
  }

  def records = { 
    def result = [:]
    println "Home"

    println "User: ${authenticatedUser.username}"
    result.user = authenticatedUser

    // println "done"
    result
  }

  def edit = {
    def result = [:]
    println "Edit"

    println "User: ${authenticatedUser.username}"
    result.user = authenticatedUser

    // println "done"
    result
  }

  def users = {
    def result = [:]
    println "Users"

    println "User: ${authenticatedUser.username}"
    result.user = authenticatedUser

    // println "done"
    result
  }



}
