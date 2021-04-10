package com.apurba.diceroller_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var ivRollDice : ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.button_roll)
        rollButton.text = "Let's Roll"
        rollButton.setOnClickListener {
            rollDice()
        }

        val lessonTwoButton : Button = findViewById(R.id.button_lesson_2)
        lessonTwoButton.text = "Lest go to lesson 2"
        lessonTwoButton.setOnClickListener{
            val intent = Intent(this, LessonTwoActivity::class.java)
            startActivity(intent)
        }

        ivRollDice = findViewById(R.id.iv_dice_roll)
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6) + 1
        val diceResource = when(randomInt){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        ivRollDice.setImageResource(diceResource)
    }
}