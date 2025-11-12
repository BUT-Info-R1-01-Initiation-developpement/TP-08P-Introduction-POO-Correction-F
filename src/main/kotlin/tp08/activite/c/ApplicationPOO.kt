package tp08.activite.c

fun main() {
    println("=== Gestion de Playlist Musicale ===\n")

    try {
        // Demander le nombre de chansons
        print("Combien de chansons dans votre playlist ? ")
        val nombreChansons = readln().toInt()
        check(nombreChansons > 0) { "❌ Le nombre de chansons doit être positif !" }

        // Créer une playlist
        val thePlaylist = Playlist()

        // Saisir chaque chanson
        println("\nSaisissez les informations de chaque chanson :")
        for (i in 0 until nombreChansons) {
            println("\n--- Chanson ${i + 1} ---")
            print("Titre : ")
            val titre = readln()
            print("Durée (en secondes) : ")
            val duree = readln().toInt()
            val chanson = Chanson(titre, duree)
            thePlaylist.ajouterChanson(chanson)
        }

        println(thePlaylist.rapportDetaille())

    } catch (e: NumberFormatException) {
        println("\n❌ Erreur : Vous devez saisir un nombre valide !")
    } catch (e: IllegalStateException) {
        println(e.message)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}