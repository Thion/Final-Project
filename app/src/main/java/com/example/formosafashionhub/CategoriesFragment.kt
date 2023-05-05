package com.example.formosafashionhub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint

class CategoriesFragment : Fragment(R.layout.fragment_categories)  {
    private lateinit var allClothesTextView: TextView
    private lateinit var menTrousersTextView: TextView
    private lateinit var ladiesTrousersTextView: TextView
    private lateinit var dressAndSkirtsTextView: TextView
    private lateinit var shirtsAndBlousesTextView: TextView
    private lateinit var othersTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categories, container, false)
        allClothesTextView = view.findViewById(R.id.mTvAllClothes)
        menTrousersTextView = view.findViewById(R.id.mTvMenTrousers)
        ladiesTrousersTextView = view.findViewById(R.id.mTvLadiesTrousers)
        dressAndSkirtsTextView = view.findViewById(R.id.mTvDress)
        shirtsAndBlousesTextView = view.findViewById(R.id.mTvShirts)
        othersTextView = view.findViewById(R.id.mTvOthers)

        menTrousersTextView.setOnClickListener {


        }
        ladiesTrousersTextView.setOnClickListener {

        }
        dressAndSkirtsTextView.setOnClickListener {

        }
        shirtsAndBlousesTextView.setOnClickListener {

        }
        othersTextView.setOnClickListener {

        }



        return view
    }

}

