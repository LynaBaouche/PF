package cours1

object Shoppingcart
{
  def getDiscountpercentage(items: List[String]): Int = {
    if (items.contains("Book")) 5 else 0
  }

  def getTipPercentage(names: List[String]): Int = {
    if (names.size > 5) 20
    else if (names.size > 0) 10
    else 0
  }
}





//plus facile en Scala car les listes sont déjà Immutables
@main
def testShoppingcart(): Unit = {
  var justApple = List("Apple")
  var AppleBook=List("Apple","Book")
  //les listes en Scala sont immutables, on ne peut aps ajoute rdes élément à une liste existante
  //justApple.append("Book") //ne compile pas
  var SmallGroup= List("Alice", "Bob", "Charlie")
  var BigGroup = List("Alice", "Bob", "Charlie", "David", "Eve", "Frank","Emily")
  println(Shoppingcart.getTipPercentage(List.empty))
  println(Shoppingcart.getTipPercentage(SmallGroup))
  println(Shoppingcart.getTipPercentage(BigGroup))
  println(Shoppingcart.getDiscountpercentage(justApple))
  println(Shoppingcart.getDiscountpercentage(AppleBook))


}