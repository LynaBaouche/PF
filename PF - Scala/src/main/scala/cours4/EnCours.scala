package cours4

object EnCours {
  def score (word :String): Int = word.replaceAll("a","").length

  def rankedWords(scoring: String => Int, words: List[String]): List[String] = {
    def negativeScoring(word: String): Int = -scoring(word)

    words.sortBy(negativeScoring)
  }


  @main
  def main (): Unit = {
    val words: List[String] = List("java", "scala", "ada","haskell", "rust")
    println(rankedWords(score, words))
  }
  

}
