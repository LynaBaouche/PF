package cours4

  def largerThan(n: Int)(i: Int): Boolean = i > n

  val result = List(5,1,2,4,0).filter(largerThan(4))

  def dividablebyn(n: Int)(i: Int): Boolean = i % n == 0
  val result2 = List(5,1,2,4,0,10).filter(dividablebyn(5))
  @main def testCurryfying(): Unit = {
    println(result)
    println(result2)
  }
