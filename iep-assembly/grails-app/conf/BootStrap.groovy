class BootStrap {

    def ontologyService 

    def init = { servletContext ->

      ontologyService.sync();

    }
    def destroy = {
    }
}
