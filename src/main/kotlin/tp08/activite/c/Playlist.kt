package tp08.activite.c

class Playlist {
    val chansons = Array<Chanson?>(200) { null }
    var nombreChansons = 0

    /**
     * Ajoute une chanson à la playlist.
     *
     * @param chanson la chanson à ajouter
     * @throws IllegalArgumentException si la playlist contient déjà 200 chansons
     */
    fun ajouterChanson(chanson: Chanson) {
        require(this.nombreChansons < 200) {
            "La playlist est pleine."
        }
        this.chansons[this.nombreChansons] = chanson
        this.nombreChansons++
    }

    /**
     * Calcule la durée totale de la playlist
     *
     * @return la durée totale
     */
    fun calculerDureeTotale(): Int {
        var dureeTotal = 0
        for (i in 0..<this.nombreChansons) {
            val chansonCourante = chansons[i]
            dureeTotal += chansonCourante!!.dureeEnSecondes
        }
        return dureeTotal
    }

    /**
     * trouve l'index de la chanson la plus longue
     *
     * @return l'index de la chanson la plus longue
     * @throws IllegalArgumentException si le tableau des durées est vide.
     */
    fun trouverIndexChansonPlusLongue(): Int {
        require(this.nombreChansons > 0) {"Le tableau des chansons ne peut pas être vide."}
        var indexPlusLongue = 0
        var dureePlusLongue = this.chansons[0]!!.dureeEnSecondes
        for (i in 1..<this.nombreChansons) {
            val chansonCourante = chansons[i]
            if (chansonCourante!!.dureeEnSecondes > dureePlusLongue) {
                dureePlusLongue = chansonCourante.dureeEnSecondes
                indexPlusLongue = i
            }
        }
        return indexPlusLongue
    }

    /**
     * Génère le rapport détaillé de la playlist
     *
     * @return le rapport détaillé
     */
    fun rapportDetaille(): String {
        // Calculer la durée totale
        val dureeTotal = this.calculerDureeTotale()

        // Convertir en minutes et secondes
        val minutes = dureeTotal / 60
        val secondes = dureeTotal % 60

        // Rapport
        val entete = """
            === Résumé de votre playlist ===
            Nombre de chansons : ${this.nombreChansons}
            Durée totale : ${minutes} min ${secondes} s
            Chanson la plus longue : ${this.chansonPlusLongue().rapportDetaille()}
        """.trimIndent()
        var listeChansons = "\n=== Liste des chansons ===\n"
        for (i in 0 until this.nombreChansons) {
            val chansonCourante = this.chansons[i]!!
            listeChansons += "${i + 1}. ${chansonCourante.rapportDetaille()}\n"
        }
        return "\n$entete\n$listeChansons"
    }

    /**
     * Trouve la chanson la plus longue
     *
     * @return la chanson la plus longue (première trouvée si plusieurs dans la liste)
     */
    fun chansonPlusLongue(): Chanson {
        return this.chansons[trouverIndexChansonPlusLongue()]!!
    }
}