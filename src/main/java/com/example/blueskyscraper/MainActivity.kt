    package com.example.blueskyscraper

    import android.content.Intent
    import android.os.Bundle
    import android.widget.*
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.content.ContextCompat.startActivity
    import java.util.ArrayList

    class MainActivity : AppCompatActivity() {

        private val songTitles = mutableListOf("Song A" , "Song B" , "Song C" , "Song D")
        private val artistNames = mutableListOf("Artist A" , "Artist B" , "Artist C" , "Artist D")
        private val ratings = mutableListOf(4 , 1 , 2 , 3)
        private val comments = mutableListOf("Rap" , "Dance song" , "Best Love song" , "Memories")

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val titleInput = findViewById<EditText>(R.id.editTitle)
            val artistInput = findViewById<EditText>(R.id.editArtist)
            val ratingInput = findViewById<EditText>(R.id.editRating)
            val commentInput = findViewById<EditText>(R.id.editComment)

            val btnAdd = findViewById<Button>(R.id.btnAdd)
            val btnView = findViewById<Button>(R.id.btnView)
            val btnExit = findViewById<Button>(R.id.btnExit)

            btnAdd.setOnClickListener {
                val title = titleInput.text.toString()
                val artist = artistInput.text.toString()
                val ratingStr = ratingInput.text.toString()
                val comment = commentInput.text.toString()

                val rating = ratingStr.toIntOrNull()
                if (title.isEmpty() || artist.isEmpty() || rating == null || comment.isEmpty()) {
                    Toast.makeText(this , "Please fill all fields correctly" , Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                if (rating !in 1..5) {
                    Toast.makeText(this , "Rating must be between 1 and 5" , Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                songTitles.add(title)
                artistNames.add(artist)
                ratings.add(rating)
                comments.add(comment)

                Toast.makeText(this , "Song added to playlist" , Toast.LENGTH_SHORT).show()

                titleInput.text.clear()
                artistInput.text.clear()
                ratingInput.text.clear()
                commentInput.text.clear()
            }

            btnView.setOnClickListener {
                val intent = Intent(this , RatingActivity::class.java)
                intent.putStringArrayListExtra("titles" , ArrayList(songTitles))
                intent.putStringArrayListExtra("artists" , ArrayList(artistNames))
                intent.putIntegerArrayListExtra("ratings" , ArrayList(ratings))
                intent.putStringArrayListExtra("comments" , ArrayList(comments))
                startActivity(intent)
            }

            btnExit.setOnClickListener {
                finishAffinity()
            }
        }
    }



