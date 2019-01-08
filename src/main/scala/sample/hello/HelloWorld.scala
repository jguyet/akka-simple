package sample.hello

import akka.actor.Actor
import akka.actor.Props

object HelloWorld {
  case class TT(b : Boolean)
}

class HelloWorld extends Actor {

  override def preStart(): Unit = {
    // create the greeter actor
    val greeter = context.actorOf(Props[Greeter], "greeter")
    // tell it to perform the greeting
    greeter.tell(Greeter.Message("HelloWorld"), self)
  }

  def receive = {
    case Greeter.Message(msg) => {
      println("HelloWorld received : " + msg)
      msg match {
        case "GREETER RESPONSE" => self.tell(Greeter.Terminated, self)
        case _ => println("UNKNOWN RESPONSE : " + msg)
      }
    }
    case Greeter.Terminated => {
      println("HelloWorld received : Terminated STATE")
      context.stop(self)
    }
  }
}

