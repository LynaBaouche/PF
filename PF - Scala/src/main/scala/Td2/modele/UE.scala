package Td2.modele

// possible fuite donnée sur ects
final case class UE(nom: String, ects: Map[Matiere, Int])
