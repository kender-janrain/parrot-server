package janrain.jedi.parrot

import akka.actor.{Props, Actor, ActorSystem}
import spray.can.Http
import spray.http._
import akka.io.IO
import spray.http.HttpRequest
import spray.http.HttpResponse

object ParrotServer {
  class ParrotListener extends Actor {
    def receive = {
      case Http.Connected(_, _) ⇒
        sender ! Http.Register(self)

      case HttpRequest(m, path, _, entity, _) ⇒
        println(s"$m $path")
        println(entity.asString)
        sender ! HttpResponse()
    }
  }

  def main(args: Array[String]) {
    val port = args(0).toInt

    implicit val actorSystem = ActorSystem("parrot")

    val listener = actorSystem.actorOf(Props[ParrotListener])
    IO(Http) ! Http.Bind(listener, interface = "0.0.0.0", port = port)
  }
}
