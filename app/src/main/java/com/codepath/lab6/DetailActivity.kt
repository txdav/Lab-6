
package com.codepath.lab6

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailImageView: ImageView = findViewById(R.id.detailImage)
        val detailTitleTextView: TextView = findViewById(R.id.detailTitle)
        val detailDescriptionTextView: TextView =
            findViewById(R.id.detailDescription)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Explore"

        val park = intent.getSerializableExtra(PARK_EXTRA) as? Park
        val campground =
            intent.getSerializableExtra(CAMPGROUND_EXTRA) as? Campground

        when {
            park != null -> {
                detailTitleTextView.text = park.fullName
                detailDescriptionTextView.text = park.description

                Glide.with(this)
                    .load(park.imageUrl)
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .error(android.R.drawable.ic_menu_gallery)
                    .fitCenter()
                    .into(detailImageView)
            }

            campground != null -> {
                detailTitleTextView.text = campground.name
                detailDescriptionTextView.text = campground.description

                Glide.with(this)
                    .load(campground.imageUrl)
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .error(android.R.drawable.ic_menu_gallery)
                    .fitCenter()
                    .into(detailImageView)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
