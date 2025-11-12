package tp08.activite.c

data class Chanson(
    val titre: String,
    val dureeEnSecondes: Int
) {
    init {
        require(this.titre.isNotBlank()) {
            "Titre doit avoir du contenu."
        }
        require(this.dureeEnSecondes in 1..1800) {
            "DureeEnSecondes doit être comprise entre 1 et 1800 secondes."
        }
    }

    fun rapportDetaille(): String {
        val min =  this.dureeEnSecondes / 60
        val sec =   this.dureeEnSecondes % 60
        return "${this.titre} - ${min}:${sec.toString().padStart(2, '0')}"
    }
}

