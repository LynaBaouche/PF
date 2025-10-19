package Td1

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Td01 {
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

  def main(args: Array[String]): Unit = {
    val rawInformation = List(
      "2017-05-08T14:39:06 -- France -- This is an information -- tag1 -- 2€",
      "2017-05-08T14:49:06 -- UK -- This is another information -- tag1,tag2 -- 4€",
      "2018-05-10T14:39:06 -- France -- This is a newer information -- tag3 -- 8€"
    )
    val information = rawInformation.map(parseInformation(_))
    println(information)
    // la suite
  }
}
