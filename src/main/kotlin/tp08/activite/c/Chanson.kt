package tp08.activite.c

data class Chanson(val titre: String, val dureeEnSecondes: Int) {

    init {
        require(this.titre.isNotBlank()) { "Le titre doit avoir du contenu"}
        require(this.dureeEnSecondes > 0) { "La durée doit être strictement supérieure à 0"}
        require(this.dureeEnSecondes <= 1800) { "La durée ne doit pas dépasser 30 mn"}
    }
}
