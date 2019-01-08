package sample.hello

import akka.actor.Actor

object Greeter {
  case object Start
  case object Terminated
  case class Message(msg: String)
}

class Greeter extends Actor {
  def receive() = {
    case Greeter.Message(msg) => {
      println("Greeter received    : " + msg)
      sender().tell(Greeter.Message("GREETER RESPONSE"), self)
    }
    case (_) => {
      println("Unknown message")
      unhandled(_)
    }
  }
}