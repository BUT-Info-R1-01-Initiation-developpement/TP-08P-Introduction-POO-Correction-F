package tp08.activite.c

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PlaylistTest {

    @Test
    fun `test création d'une playlist`() {
        val maPlaylist = Playlist()
        assertEquals(0, maPlaylist.nombreChansons)
        assertEquals(200, maPlaylist.chansons.size)
        for (chanson in maPlaylist.chansons) {
            assertNull(chanson)
        }
    }

    // -----  tests de la fonction ajouterChanson() -----

        @Test
        fun `test ajout d'une chanson à une playlist vierge`() {
            // Given : une playlist vierge et une chanson
            val maPlaylist = Playlist()
            val oneU2 = Chanson("One", 276)
            // When : on ajoute une chanson
            maPlaylist.ajouterChanson(oneU2)
            // Then
            assertEquals(1, maPlaylist.nombreChansons)
            assertEquals(oneU2, maPlaylist.chansons[0])
            for (i in 1..< maPlaylist.chansons.size) {
                assertNull(maPlaylist.chansons[i])
            }
        }

        @Test
        fun `test ajout d'une chanson à une playlist contenant quelques chansons`() {
            // Given : une playlist contenant 3 chansons
            val maPlaylist = Playlist()
            maPlaylist.ajouterChanson(Chanson("One", 276))
            maPlaylist.ajouterChanson(Chanson("Two", 300))
            maPlaylist.ajouterChanson(Chanson("Three",400))
            assertEquals(3, maPlaylist.nombreChansons)

            // When : on ajoute une chanson
            val four = Chanson("Four", 500)
            maPlaylist.ajouterChanson(four)
            // Then
            assertEquals(4, maPlaylist.nombreChansons)
            assertEquals(four, maPlaylist.chansons[3])
            for (i in 4..< maPlaylist.chansons.size) {
                assertNull(maPlaylist.chansons[i])
            }
        }

        @Test
        fun `test ajout d'une chanson à une playlist contenant déjà 200 chansons`() {
            // Given : une playlist contenant 3 chansons
            val maPlaylist = Playlist()
            for (i in maPlaylist.chansons.indices) {
                maPlaylist.ajouterChanson(Chanson("Chanson ${i}", i+30))
            }
            assertEquals(200, maPlaylist.nombreChansons)

            // Une exception est levée quand on ajoute une chanson
            assertThrows<IllegalArgumentException> {
                maPlaylist.ajouterChanson(Chanson("Four", 200))
            }

        }


        // -----  tests de la fonction ajouterChanson() -----

        @Test
        fun `test durée totale d'une playlist vierge`() {
            // Given : une playlist vierge et une chanson
            val maPlaylist = Playlist()
            // Then
            assertEquals(0, maPlaylist.calculerDureeTotale())
        }

          @Test
          fun `test durée totale d'une playlist avec quelques chansons`() {
              // Given : une playlist
              val maPlaylist = Playlist()
              maPlaylist.ajouterChanson(Chanson("One", 276))
              maPlaylist.ajouterChanson(Chanson("Two", 300))
              maPlaylist.ajouterChanson(Chanson("Three",400))
              // Then
              assertEquals(976, maPlaylist.calculerDureeTotale())
          }
    /*
            // -----  tests de la fonction trouverIndexChansonPlusLongue() -----

        // ========== Tests pour trouverIndexChansonPlusLongue ==========

            @Test
            fun `trouverIndexChansonPlusLongue avec chanson longue au milieu`() {
                // Given
                val maPlaylist = Playlist()
                maPlaylist.ajouterChanson(Chanson("One", 276))
                maPlaylist.ajouterChanson(Chanson("Two", 300))
                maPlaylist.ajouterChanson(Chanson("Three",400))
                maPlaylist.ajouterChanson(Chanson("Three",200))

                // When
                val resultat = maPlaylist.trouverIndexChansonPlusLongue()

                // Then
                assertEquals(2, resultat)
            }

            @Test
            fun `trouverIndexChansonPlusLongue avec chanson longue au début`() {
                // Given
                val maPlaylist = Playlist()
                maPlaylist.ajouterChanson(Chanson("One", 876))
                maPlaylist.ajouterChanson(Chanson("Two", 300))
                maPlaylist.ajouterChanson(Chanson("Three",400))
                maPlaylist.ajouterChanson(Chanson("Three",200))

                // When
                val resultat = maPlaylist.trouverIndexChansonPlusLongue()

                // Then
                assertEquals(0, resultat)
            }

            @Test
            fun `trouverIndexChansonPlusLongue avec chanson longue à la fin`() {
                // Given
                val maPlaylist = Playlist()
                maPlaylist.ajouterChanson(Chanson("One", 276))
                maPlaylist.ajouterChanson(Chanson("Two", 300))
                maPlaylist.ajouterChanson(Chanson("Three",400))
                maPlaylist.ajouterChanson(Chanson("Three",800))

                // When
                val resultat = maPlaylist.trouverIndexChansonPlusLongue()

                // Then
                assertEquals(3, resultat)
            }

            @Test
            fun `trouverIndexChansonPlusLongue avec toutes les durées identiques`() {
                // Given
                val maPlaylist = Playlist()
                maPlaylist.ajouterChanson(Chanson("One", 200))
                maPlaylist.ajouterChanson(Chanson("Two", 200))
                maPlaylist.ajouterChanson(Chanson("Three",200))
                maPlaylist.ajouterChanson(Chanson("Three",200))

                // When
                val resultat = maPlaylist.trouverIndexChansonPlusLongue()

                // Then
                assertEquals(0, resultat)// Devrait retourner le premier index
            }

            @Test
            fun `trouverIndexChansonPlusLongue avec une seule chanson`() {
                // Given
                val maPlaylist = Playlist()
                maPlaylist.ajouterChanson(Chanson("One", 276))

                // When
                val resultat = maPlaylist.trouverIndexChansonPlusLongue()

                // Then
                assertEquals(0, resultat)
            }

            @Test
            fun `trouverIndexChansonPlusLongue avec tableau vide lance exception`() {
                // Given
                val maPlaylist = Playlist()

                // When & Then
                assertThrows<IllegalArgumentException> {
                    maPlaylist.trouverIndexChansonPlusLongue()
                }
            }

        */
}