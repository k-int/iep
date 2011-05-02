class UrlMappings {

	static mappings = {
		// "/$controller/$action?/$id?"{
		// 	constraints {
		// 		// apply constraints here
		// 	}
		// }

                "/about" (controller:"about", action:"index")

                "/authority/${authority}" (controller:"authority", action:"index")

                "/resource/$id" (controller:"resource", action:"index")

		"/" (controller:"home", action:"index")
		"500"(view:'/error')
	}
}
