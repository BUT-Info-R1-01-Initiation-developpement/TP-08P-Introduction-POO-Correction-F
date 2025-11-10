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

}