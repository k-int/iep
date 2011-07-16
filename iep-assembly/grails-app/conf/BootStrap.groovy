import com.k_int.sim.*;
import grails.plugins.nimble.InstanceGenerator
import grails.plugins.nimble.core.LevelPermission
import grails.plugins.nimble.core.Role
import grails.plugins.nimble.core.Group
import grails.plugins.nimble.core.AdminsService
import grails.plugins.nimble.core.UserService
import com.k_int.iep.datamodel.*;

class BootStrap {

  def grailsApplication
  def nimbleService
  def userService
  def adminsService
  def ontologyService 

  def init = { servletContext ->

    println "BootStrap"

    // The following must be executed before any other nimble code
    nimbleService.init()

    // Create example Administrative account
    println "Verifying admin account"
    def userLookup = User.findByUsername('admin')
    if ( userLookup == null ) {
      println "Create admin account..."
      def admins = Role.findByName(AdminsService.ADMIN_ROLE)
      def admin = InstanceGenerator.user()
      admin.username = "admin"
      admin.pass = "admiN123!"
      admin.passConfirm = "admiN123!"
      admin.enabled = true

      def adminProfile = InstanceGenerator.profile()
      adminProfile.fullName = "Administrator"
      adminProfile.owner = admin
      admin.profile = adminProfile

      // userLookup = grails.plugins.nimble.core.UserBase.findByUsername(admin.username)
      def savedAdmin = userService.createUser(admin)

      if (savedAdmin.hasErrors()) {
        savedAdmin.errors.each {
          log.error(it)
        }
        throw new RuntimeException("Error creating administrator")
      }

      adminsService.add(admin)
    }


    println "BootStrap"
    ontologyService.sync();

    // Create some test data, only for testing
    IEPProvider t1 = IEPProvider.findByIdentifier("test1") ?: new IEPProvider(identifier:"test1",shortCode:"test1",email:"a@b.c.d").save(flush:true);

    IEPSubscriptionType none = IEPSubscriptionType.findByCode('none') ?: new IEPSubscriptionType(code:'none',description:'None').save(flush:true);
    IEPSubscriptionType basic = IEPSubscriptionType.findByCode('basic') ?: new IEPSubscriptionType(code:'basic',description:'Basic').save(flush:true);
    IEPSubscriptionType pro = IEPSubscriptionType.findByCode('pro') ?: new IEPSubscriptionType(code:'pro',description:'Professional').save(flush:true);
  }

  def destroy = {
  }

}
