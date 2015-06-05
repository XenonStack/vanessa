package com.xenonstack.vanessa.web

import com.twitter.finatra.Controller
import com.twitter.finatra.FinatraServer

class HTTPServer{


	def start(): Unit = {
		val server: FinatraServer = new FinatraServer()
		server.register(new example())
		server.register(new User())
		server.start()
		
	}

}
class example extends Controller {

 get("/") { request =>
    render.plain("Welcome").toFuture
  }}
