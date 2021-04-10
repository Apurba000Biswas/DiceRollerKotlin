package com.apurba.diceroller_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.apurba.diceroller_kotlin.databinding.ActivityLessonTwoBinding
import com.squareup.picasso.Picasso

class LessonTwoActivity : AppCompatActivity() {

    lateinit var binding : ActivityLessonTwoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson_two)

        findViewById<Button>(R.id.button).setOnClickListener(){
            onDoneButtonClicked(it)
        }

        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Green_star.svg/1200px-Green_star.svg.png").into(binding.imageView)

    }

    private fun onDoneButtonClicked(view : View) {

        binding.apply {
            binding.name.text = "Hi, " + binding.editText.text
            invalidateAll()
            binding.editText.visibility = View.GONE
            binding.button.visibility = View.GONE
            binding.name.visibility = View.VISIBLE
        }


        // hide key board
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}