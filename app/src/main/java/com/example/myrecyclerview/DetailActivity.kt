package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val heroId = intent.getIntExtra("HERO_ID", -1)
        val hero = getHeroById(heroId, MainActivity().getListHeroes())
        populateData(hero)
    }

    private fun getHeroById(heroId: Int, list: ArrayList<Hero>): Hero? {
        return list.find { it.id == heroId }
    }
    private fun populateData(hero: Hero?) {

        if (hero != null) {
            findViewById<ImageView>(R.id.img_detail_photo).setImageResource(R.drawable.samsung_m34)
            findViewById<TextView>(R.id.tv_detail_name).text = hero.name
            findViewById<TextView>(R.id.tv_detail_specification).text = "Spesifikasi: " + hero.description
            findViewById<TextView>(R.id.tv_detail_description).text = hero.description
        } else {
            Toast.makeText(this, "ID pahlawan tidak valid", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
