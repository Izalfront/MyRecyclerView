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
        val heroList = intent.getParcelableArrayListExtra<Hero>("HERO_LIST") ?: java.util.ArrayList()

        if (heroId != -1 && heroList != null) {
            val hero = getHeroById(heroId, heroList)
            if (hero != null) {
                populateData(hero)
            } else {
                Toast.makeText(this, "ID pahlawan tidak valid", Toast.LENGTH_SHORT).show()
                finish()
            }
        } else {
            Toast.makeText(this, "Data pahlawan tidak valid", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun getHeroById(heroId: Int, list: List<Hero>): Hero? {
        return list.find { it.id == heroId }
    }
    private fun populateData(hero: Hero) {
        findViewById<ImageView>(R.id.img_detail_photo).setImageResource(R.drawable.samsung_m34)
        findViewById<TextView>(R.id.tv_detail_name).text = hero.name
        findViewById<TextView>(R.id.tv_detail_specification).text = "Spesifikasi: " + hero.description
        findViewById<TextView>(R.id.tv_detail_description).text = hero.description
        findViewById<TextView>(R.id.detail_spec).text = "Deskripsi: " + hero.description
    }
}
