package tp08.activite.c

/**
 * Calcule la durée totale de la playlist
 *
 * @param durees le tableau contenant les durées des chansons
 * @return la durée totale
 */
fun calculerDureeTotale(durees: Array<Int>): Int {
    var dureeTotal = 0
    for (duree in durees) {
        dureeTotal += duree
    }
    return dureeTotal
}

/**
 * trouve l'index de la chanson la plus longue
 *
 * @param durees le tableau contenant les durées des chansons
 * @return l'index de la chanson la plus longue
 * @throws IllegalArgumentException si le tableau des durées est vide.
 */
fun trouverIndexChansonPlusLongue(durees: Array<Int>): Int {
    require(durees.isNotEmpty()) {"Le tableau des durées ne peut pas être vide."}
    var indexPlusLongue = 0
    var dureePlusLongue = durees[0]
    for (i in 1 until durees.size) {
        if (durees[i] > dureePlusLongue) {
            dureePlusLongue = durees[i]
            indexPlusLongue = i
        }
    }
    return indexPlusLongue
}

/**
 * Ajoute une chanson à la playlist.
 * Le titre doit être non vide et la durée comprise entre 1 et 600 secondes
 *
 * @param titres le tableau des titres
 * @param durees le tableau des durées
 * @param indice l'indice utilisé pour ajouter la chanson dans les tableaux
 * @param titre le titre de la chanson à ajouter
 * @param duree la durée de la chanson à ajouter
 *
 * @throws IllegalArgumentException si le titre est vide ou si la durée n'est pas comprise entre 1 et 600,
 * si l'indice n'est pas valide
 */
fun ajouterChanson(titres: Array<String>, durees: Array<Int>, indice: Int, titre: String, duree: Int){
    require(titres.size == durees.size)
    require(indice in titres.indices)
    require(titre.isNotBlank()) { "❌ Le titre ne doit pas être vide !" }
    require(duree > 0) {"❌ La durée doit être positive !"}
    require(duree <= 600) {"❌ La durée ne peut pas dépasser 10 minutes (600 secondes) !"}
    titres[indice] = titre
    durees[indice] = duree
}