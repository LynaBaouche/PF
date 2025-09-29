package cours1

def firstTwo(list: List[String]): List[String] =
  list.slice(0, 2)
def lastTwo(list: List[String]): List[String] =
  list.slice(list.size - 2, list.size)
def movedFirstTwoToTheEnd(list: List[String]): List[String] = {
  val firstTwo = list.slice(0, 2)
  val withoutFirstTwo = list.slice(2, list.size)
  withoutFirstTwo.appendedAll(firstTwo)
}
def insertedBeforeLast(list: List[String], element: String): List[String] = {
  val last = list.slice(list.size - 1, list.size)
  val withoutLast = list.slice(0, list.size - 1)
  withoutLast.appended(element).appendedAll(last)
}
@main def exoApp(): Unit =
  val list = List("a", "b", "c", "d")
  println(s"First two: ${firstTwo(list)}")
  println(s"Last two: ${lastTwo(list)}")
  println(s"Moved first two to end: ${movedFirstTwoToTheEnd(list)}")
  println(s"Inserted before last: ${insertedBeforeLast(list, "X")}")
