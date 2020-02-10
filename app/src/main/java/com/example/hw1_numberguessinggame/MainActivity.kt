package com.example.hw1_numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var tryNum = 0
    private var hints = ""
    private var randomNumber = genRandomNum()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //function that is attached to the Enter button
    fun guessNum(view: View){
        guessRightNum()
    }

    //function that is attached to the Play Again button
    fun playAgain(view: View){
        playGameAgain()
    }

    //function that is attached to the Give Up button
    fun showAnswer(view: View){
        Toast.makeText(this, "Answer: " + randomNumber.toString().toInt(), Toast.LENGTH_SHORT).show()
    }

    //function that is attached to the Get me out button, which close the app
    fun exitGame(view: View){
        exitProcess(1)
    }

    //function that is used by the play again button, it resets the game.
    private fun playGameAgain(){
        tryNum = 0
        hints = ""
        tries.text = "Number of tries: $tryNum"
        HintWord.text = "Hint: $hints"
    }

    //Function that is used to perform the main activity
    private fun guessRightNum(){

        if (num.text.toString().isEmpty()){
            hints = "Please enter a number"
        }
        else{
            val rnum = num.text.toString().toInt()

            if(rnum > randomNumber){
                tryNum++
                hints = "Too High!"
            }
            else if(rnum < randomNumber) {
                tryNum++
                hints = "Too Low!"
            }
            else if(rnum == randomNumber) {
                tryNum++
                hints = "Well Done!"
                randomNumber = genRandomNum()
            }
        }
        tries.text = "Number of tries: $tryNum"
        HintWord.text = "Hint: $hints"
    }

    //function that creates a random number between 1 and 100
    private fun genRandomNum(): Int{
        return Random().nextInt(100)
    }
}
