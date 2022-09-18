package com.example.videogameadvisor

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.core.text.HtmlCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findGames = findViewById<Button>(R.id.find_game)
        findGames.setOnClickListener {
            val gameGenres = findViewById<Spinner>(R.id.game_genres)
            val genre = gameGenres.selectedItem;
            val gamesList = getGames(genre.toString())
            val reducedGamesList = gamesList.reduce {str, item->str + '\n'+ item}
            val games = findViewById<TextView>(R.id.games)
            val gameDescription = getSelectedGameDescription(genre.toString())
            val description = findViewById<TextView>(R.id.game_description)
            val descriptionText = "<b>Description</b><br/>$gameDescription"
            games.text = reducedGamesList;
            description.text =  HtmlCompat.fromHtml(descriptionText,HtmlCompat.FROM_HTML_MODE_LEGACY);
        }
    }
    private fun getGames(genre:String) : List<String> {
        return  when(genre){
            "Action" -> listOf("legend of Zelda","GTA5")
            "Adventure" -> listOf("Final Fantasy","Elden Ring")
            "Strategy" -> listOf("Age of Empires","StarCraft")
            "Sports" -> listOf("FIFA22", "NBA2k22")
            "RPG" -> listOf("ELder Scrolls 4", "Fallout")
            else -> listOf("Super Mario", "Kirby")
        }
    }

    private fun getSelectedGameDescription(genre:String) : String {
        return  when(genre){
            "Action" -> "Emphasizes physical challenges, including hand–eye coordination and reaction-time"
            "Adventure" -> "Player assumes the role of a protagonist in an interactive story driven by exploration and/or puzzle-solving"
            "Strategy" -> "Players' uncoerced, and often autonomous, decision-making skills have a high significance in determining the outcome"
            "Sports" -> "Simulates the practice of sports"
            "RPG" -> "Role playing game"
            else -> "Fantasy series for entertainment"
        }
    }

}