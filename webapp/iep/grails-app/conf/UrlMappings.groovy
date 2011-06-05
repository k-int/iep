class UrlMappings {

	static mappings = {
		// "/$controller/$action?/$id?"{
		// 	constraints {
		// 		// apply constraints here
		// 	}
		// }

                "/about" (controller:"about", action:"index")

                "/authority/${authority}" (controller:"authority", action:"dashboard")
                "/authority/${authority}/dashboard" (controller:"authority", action:"dashboard")
                "/authority/${authority}/records" (controller:"authority", action:"records")

                "/resource/$id" (controller:"resource", action:"index")

		"/" (controller:"home", action:"index")
		"500"(view:'/error')
	}
}
