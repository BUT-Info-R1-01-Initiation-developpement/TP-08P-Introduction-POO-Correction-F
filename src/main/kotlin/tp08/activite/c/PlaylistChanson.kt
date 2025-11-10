package tp08.activite.c

class Playlist {
    val chansons = Array<Chanson?>(200) { null }
    var nombreChansons = 0

    /**
     * Ajoute une chanson à la liste
     *
     * @param chanson la chanson à ajouter
     */
    fun ajouterChanson(chanson: Chanson) {
        require(this.nombreChansons < 200) { "La liste est déjà pleine." }
        this.chansons[this.nombreChansons] = chanson
        this.nombreChansons++
    }

    /**
     * Calcule la duree totale de la playlist
     *
     * @return la duree totale de la playlist
     */
    fun calculerDureeTotale(): Int {
        var dureeTotale = 0
        for (i in 0 until this.nombreChansons) {
            dureeTotale += this.chansons[i]!!.dureeEnSecondes
        }
        return dureeTotale
    }

    /**
     * Trouve le premier index de la chanson la plus longue
     *
     * @return l'index de la chanson la plus longue (premier index)
     */
    fun trouverIndexChansonPlusLongue():Int {
        require(this.nombreChansons > 0) {"Pas de chanson dans la liste !"}
        var dureePlusLongue = this.chansons[0]!!.dureeEnSecondes
        var indiceChansonPlusLongue = 0
        for (i in 0 until this.nombreChansons) {
            val chansonCourante = this.chansons[i]!!
            if (dureePlusLongue < chansonCourante.dureeEnSecondes) {
                dureePlusLongue = chansonCourante.dureeEnSecondes
                indiceChansonPlusLongue = i
            }
        }
        return indiceChansonPlusLongue
    }
}