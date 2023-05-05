package com.example.formosafashionhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CategoriesActivity : AppCompatActivity() {
    private lateinit var allClothesTextView: TextView
    private lateinit var menTrousersTextView: TextView
    private lateinit var ladiesTrousersTextView: TextView
    private lateinit var dressAndSkirtsTextView: TextView
    private lateinit var shirtsAndBlousesTextView: TextView
    private lateinit var othersTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        allClothesTextView = findViewById(R.id.mTvAllClothes)
        menTrousersTextView = findViewById(R.id.mTvMenTrousers)
        ladiesTrousersTextView = findViewById(R.id.mTvLadiesTrousers)
        dressAndSkirtsTextView = findViewById(R.id.mTvDress)
        shirtsAndBlousesTextView = findViewById(R.id.mTvShirts)
        othersTextView = findViewById(R.id.mTvOthers)
    }
}