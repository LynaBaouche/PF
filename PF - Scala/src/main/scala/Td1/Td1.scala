package Td1

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Td1 {
  case class Information(message: String, country: String, timestamp: LocalDateTime, tags: List[String], price: Int)

  def parseInformation(line: String): Information = {
    val parts = line.split("--")
    val timestamp = parts(0).trim
    val country = parts(1).trim
    val message = parts(2).trim
    val tags = parts(3).split(",").map(_.trim).toList
    val price = parts(4).split("€")(0).trim.toInt
    Information(message, country, LocalDateTime.parse(timestamp, DateTimeFormatter.ISO_LOCAL_DATE_TIME), tags, price)
  }
  def informationTimestamps(infos : List[Information]): List[LocalDateTime] = {
    infos.map(_.timestamp)
  }
  def informationTag(tag: String, infos: List[Information]): List[Information] = {
    infos.filter(_.tags.contains(tag))
  }
  def informationTagOneOf(tags: List[String], infos: List[Information]): List[Information] = {
    infos.filter(info => info.tags.exists(tags.contains))
  }
  // on peut aussi l'écrire avec un intersection
  // def informationTagOneOf(tags: List[String], infos: List[Information]): List[Information] = {
  //   infos.filter(info => info.tags.intersect(tags).nonEmpty)
  // }
  def informationMessageSuchThat(predicate: String => Boolean, infos: List[Information]): List[Information] = {
    infos.filter(info => predicate(info.message))
  }
  def informationCountry(country : String , infos : List[Information]): List[Information] = {
    infos.filter(_.country == country)
  }
  //on souhaite généraliser avec une méthode selection
  def selection[T](x: Information => T)(y: T => Boolean)(is: List[Information]): List[Information] = {
    is.filter(info => y(x(info)))
    //bien comprendre l'opération de composition des fonctions
  }
  def génèrePaire[T,U](f: T => U)(g: Int => T)(x: Int): U = {
    f(g(x))
  }




  @main
  def test(): Unit = {
    val rawInformation = List(
      "2017-05-08T14:39:06 -- France -- This is an information -- tag1 -- 2€",
      "2017-05-08T14:49:06 -- UK -- This is another information -- tag1,tag2 -- 4€",
      "2018-05-10T14:39:06 -- France -- This is a newer information -- tag3 -- 8€"
    )
    val information = rawInformation.map(parseInformation(_))
    println(information)
    println(informationTimestamps(information))
    println(informationTag("tag1", information))
    println(informationTagOneOf(List("tag2", "tag3"), information))
    println(informationMessageSuchThat(msg => msg.contains("newer"), information))
    println(informationCountry("France", information))
    val TotalCostCountry = informationCountry("France", information).map(_.price).sum
    // la suite
    val messageSelecteur = selection (i => i.message)
    val tagSelecteur = selection (_.tags)
    val countrySelecteur = selection (_.country)
    val timestampSelecteur = selection (_.timestamp)
    println(messageSelecteur(_.contains("newer"))(information))
  }
}
