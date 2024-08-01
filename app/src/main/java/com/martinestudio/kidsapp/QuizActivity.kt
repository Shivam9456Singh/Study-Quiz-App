package com.martinestudio.kidsapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.martinestudio.kidsapp.databinding.ActivityQuizBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.xml.KonfettiView
import java.util.concurrent.TimeUnit

class QuizActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizBinding.inflate(layoutInflater)
    }
    private var isClickable = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val image = intent.getIntExtra("categoryimg", 0)
        binding.categoryImg.setImageResource(image)

        binding.coinWithdrawalImage.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(this@QuizActivity.supportFragmentManager, "Test")
        }

        binding.coinWithdrawalCount.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(this@QuizActivity.supportFragmentManager, "Test")
        }

        val wrongAns = binding.button3
        val wrongAns2 = binding.button2
        val correctAns = binding.button
        val wrongAns3 = binding.button4
        val btnNext = binding.btnNext

        wrongAns.setOnClickListener {
            if (isClickable) handleWrongAnswer(wrongAns)
        }

        wrongAns2.setOnClickListener {
            if (isClickable) handleWrongAnswer(wrongAns2)
        }

        wrongAns3.setOnClickListener {
            if (isClickable) handleWrongAnswer(wrongAns3)
        }

        correctAns.setOnClickListener {
            if (isClickable) {
                handleCorrectAnswer(correctAns, wrongAns, wrongAns2, wrongAns3)
                isClickable = false
            }
        }
    }

    private fun handleWrongAnswer(button: Button) {
        button.animate().apply {
            duration = 1000
            start()
            button.setBackgroundColor(resources.getColor(R.color.red))
            button.setTextColor(resources.getColor(R.color.white))
            Toast.makeText(this@QuizActivity, "Wrong Answer", Toast.LENGTH_SHORT).show()
        }

        // Use a coroutine to delay the reset by 1 second
        GlobalScope.launch(Dispatchers.Main) {
            delay(1000)
            button.setBackgroundColor(resources.getColor(R.color.white))
            button.setTextColor(resources.getColor(R.color.black))
        }
    }

    private fun handleCorrectAnswer(button: Button, vararg otherButtons: Button) {
        button.animate().apply {
            duration = 1000
            start()
            button.setBackgroundColor(resources.getColor(R.color.green))
            button.setTextColor(resources.getColor(R.color.white))
            Toast.makeText(this@QuizActivity, "Correct Answer", Toast.LENGTH_SHORT).show()
        }
        otherButtons.forEach { it.isClickable = false }


        val konfettiView = findViewById<KonfettiView>(R.id.konfettiView)
        konfettiView.start(
            Party(
                speed = 0f,
                maxSpeed = 30f,
                damping = 0.9f,
                spread = 360,
                colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                position = Position.Relative(0.5, 0.3),
                emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100)
            )
        )
    }
}
