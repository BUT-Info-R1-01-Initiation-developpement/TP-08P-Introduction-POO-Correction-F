package tp08.activite.c

/**
 * Programme de gestion d'une playlist musicale
 */

fun main() {
    println("=== Gestion de Playlist Musicale ===\n")

    try {
        // Demander le nombre de chansons
        print("Combien de chansons dans votre playlist ? ")
        val nombreChansons = readln().toInt()
        check(nombreChansons > 0) {"❌ Le nombre de chansons doit être positif !"}

        // Créer les tableaux pour stocker les titres et durées
        val titres = Array<String>(nombreChansons) { "" }
        val durees = Array<Int>(nombreChansons) { 0 }

        // Saisir chaque chanson
        println("\nSaisissez les informations de chaque chanson :")
        for (i in 0 until nombreChansons) {
            println("\n--- Chanson ${i + 1} ---")
            print("Titre : ")
            val titre = readln()
            print("Durée (en secondes) : ")
            val duree = readln().toInt()
            ajouterChanson(titres, durees, i, titre, duree)
        }

        // Calculer la durée totale
        val dureeTotal = calculerDureeTotale(durees)

        // Convertir en minutes et secondes
        val minutes = dureeTotal / 60
        val secondes = dureeTotal % 60

        // Trouver la chanson la plus longue
        val indexPlusLongue = trouverIndexChansonPlusLongue(durees)

        // Afficher les résultats
        println("\n=== Résumé de votre playlist ===")
        println("Nombre de chansons : $nombreChansons")
        println("Durée totale : ${minutes}min ${secondes}s")
        println("Chanson la plus longue : ${titres[indexPlusLongue]} (${durees[indexPlusLongue]}s)")

        println("\n=== Liste des chansons ===")
        for (i in 0 until nombreChansons) {
            val min = durees[i] / 60
            val sec = durees[i] % 60
            println("${i + 1}. ${titres[i]} - ${min}:${sec.toString().padStart(2, '0')}")
        }

    } catch (e: NumberFormatException) {
        println("\n❌ Erreur : Vous devez saisir un nombre valide !")
    } catch (e: IllegalStateException) {
        println(e.message)
    }
}

// Quels sont les deux types d'objet du "monde réel" qui sont principalement manipulés dans ce programme ?
// Chanson
// Playlist