package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetbutton: Button
    private var firstPlayerPoints = 1
    private var SecondPlayerPoints = 1
    private lateinit var ScoreText1: TextView
    private lateinit var ScoreText2: TextView


    private var resetable = 0

    private var winnerPlayer = 0

    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        init()

    }

    private fun init() {



        ScoreText1 = findViewById(R.id.score1);
        ScoreText2 = findViewById(R.id.score2);

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)


        resetbutton = findViewById(R.id.resetbutton)

        resetbutton.setOnClickListener {
            reset()

    }
        }


    override fun onClick(clickedView: View?) {

        if (clickedView is Button) {

            var buttonNumber = 0

            when(clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
                R.id.resetbutton -> reset()
            }

            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
                
            }
        }

    }





    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1) {
            activePlayer = 2
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.WHITE)
            firstPlayer.add(buttonNumber)
        } else {
            activePlayer = 1
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.WHITE)
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()

    }



    private fun check() {

        if (firstPlayer.contains(1) && firstPlayer.contains(2)  && firstPlayer.contains(3)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2)  && secondPlayer.contains(3)) {
            winnerPlayer = 2

        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5)  && firstPlayer.contains(6)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5)  && secondPlayer.contains(6)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8)  && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8)  && secondPlayer.contains(9)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4)  && firstPlayer.contains(7)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4)  && secondPlayer.contains(7)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5)  && firstPlayer.contains(8)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5)  && secondPlayer.contains(8)) {
            winnerPlayer = 2

        }

        if (firstPlayer.contains(3) && firstPlayer.contains(6)  && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6)  && secondPlayer.contains(9)) {
            winnerPlayer = 2

        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5)  && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5)  && secondPlayer.contains(9)) {
            winnerPlayer = 2

        }

        if (firstPlayer.contains(7) && firstPlayer.contains(5)  && firstPlayer.contains(3)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(7) && secondPlayer.contains(5)  && secondPlayer.contains(3)) {
            winnerPlayer = 2

        }



        if (winnerPlayer == 1 && resetable == 0) {
            Toast.makeText(this, "First Player is the Winner!", Toast.LENGTH_SHORT).show()
            ScoreText1.text = (firstPlayerPoints++).toString()
            nocheck()
            resetable = 1
        } else if (winnerPlayer == 2 && resetable == 0) {
            Toast.makeText(this, "Second Player is the Winner", Toast.LENGTH_SHORT).show()
            ScoreText2.text = (SecondPlayerPoints++).toString()
            nocheck()
            resetable = 1

        } else if (firstPlayer.size + secondPlayer.size == 9) {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()
        }

    }

    private fun nocheck(){
        resetable = 1
        button1.isClickable = false
        button2.isClickable = false
        button3.isClickable = false
        button4.isClickable = false
        button5.isClickable = false
        button6.isClickable = false
        button7.isClickable = false
        button8.isClickable = false
        button9.isClickable = false
    }

    private fun checker(){
        resetable = 0
        button1.isClickable = true
        button2.isClickable = true
        button3.isClickable = true
        button4.isClickable = true
        button5.isClickable = true
        button6.isClickable = true
        button7.isClickable = true
        button8.isClickable = true
        button9.isClickable = true
        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
    }
    private fun reset(){
        resetable = 0
        checker()
        winnerPlayer = 0
        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""
        button1.background = null
        button2.background = null
        button3.background = null
        button4.background = null
        button5.background = null
        button6.background = null
        button7.background = null
        button8.background = null
        button9.background = null
        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

        firstPlayer = ArrayList<Int>()
        secondPlayer = ArrayList<Int>()

        activePlayer = 1

    }


}