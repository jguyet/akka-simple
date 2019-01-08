package sample.hello

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorLogging
import akka.actor.Terminated


class Terminator(ref: ActorRef) extends Actor with ActorLogging {

  context watch ref
  def receive = {

    case Terminated(_) =>
      log.info("{} has terminated, shutting down system", ref.path)
      context.system.terminate()
  }
}
