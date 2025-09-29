package cours4

/*val mots = List("java", "scala", "ada","haskell", "rust")
mots.filter(mots => mots.length <5 )
def motCourt( mot: String): Boolean = mot.length < 5

def plusQuunL(mot : String) :Boolean = mot.count(_ =='l')>1
mots.filter(plusQuunL)

val nombres = List(1,2,3,4,5,6,7,8,9)
def estPair (nombres : Int) : Boolean = nombres%2==0

def filterPair(list: List[Int], estPair: Int => Boolean): List[Int] = list.filter(estPair)
filterPair(nombres, estPair)
*/
package cours4

class Curryfying

def score(word: String): Int = word.replaceAll("a", "").length
def bonus(word: String): Int = if (word.contains("s")) 2 else 0
def malus(word: String): Int = if (word.contains("l")) 1 else 0

def highScoringWords2(scoring: String => Int): (List[String], Int) => List[String] = {
  (words: List[String], n: Int) => words.filter(w => scoring(w) > n)
}


@main
def test(): Unit = {
  val words: List[String] = List("ada", "haskell", "scala", "java", "rust")
  val highScoringSBM = highScoringWords2(w => score(w) + bonus(w) - malus(w))
  println(highScoringSBM(words, 1))
  println(highScoringSBM(words, 0))
  println(highScoringSBM(words, 5))
}



