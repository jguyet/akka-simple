package sample.hello

import akka.actor.ActorSystem
import akka.actor.Props

object Main {

  def main(args: Array[String]): Unit = {
    //create System Hello Actor Manager  : akka://Hello/user
    val system = ActorSystem("Hello")

    val a = system.actorOf(Props[HelloWorld], "helloWorld")

    system.actorOf(Props(classOf[Terminator], a), "terminator")
  }



}