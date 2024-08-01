package com.martinestudio.kidsapp.Fragment

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.martinestudio.kidsapp.databinding.FragmentSpinBinding
import kotlin.random.Random
import android.util.Log
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.martinestudio.kidsapp.Withdrawal

class SpinFragment : Fragment() {
    private val binding: FragmentSpinBinding by lazy {
        FragmentSpinBinding.inflate(layoutInflater)
    }
    private lateinit var timer: CountDownTimer
    lateinit var resultValue:String
    private val itemTitles = arrayOf("Lost", "100", "500", "Try Again", "200", "Try Again", "50")
    private val degreeToValueMap = mapOf(
        0f to "Lost",
        51.4286f to "100",
        102.8572f to "50",
        154.2858f to "Try Again",
        205.7144f to "200",
        257.143f to "Try Again",
        308.5716f to "500"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,

    ): View {
        // Inflate the layout for this fragment
        binding.coinWithdrawalImage.setOnClickListener{
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"Test")
            bottomSheetDialog.enterTransition
        }
        binding.coinWithdrawalCount.setOnClickListener{
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"Test")
            bottomSheetDialog.enterTransition
        }
        return binding.root
    }

    private fun showResult(itemTitle: String) {
        Toast.makeText(requireContext(), itemTitle, Toast.LENGTH_SHORT).show()
        binding.btnSpin.isEnabled = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSpin.setOnClickListener {
            binding.btnSpin.isEnabled = false

            val spin = Random.nextInt(itemTitles.size)
            val degreesPerSegment = 360f / itemTitles.size
            val totalDegrees = degreesPerSegment * spin + (360 * 3) // Adding 3 full rotations for a dramatic spin

            Log.d("SpinFragment", "Spin: $spin, Degrees: $totalDegrees, Value: ${itemTitles[spin]}")

            timer = object : CountDownTimer(5000, 50) {
                var rotation = 0f

                override fun onTick(millisUntilFinished: Long) {
                    rotation += 20f
                    binding.wheel.rotation = rotation % 360
                }

                override fun onFinish() {
                    val finalRotation = totalDegrees % 360
                    binding.wheel.rotation = finalRotation
                    Log.d("SpinFragment", "Final Rotation: $finalRotation, Value: ${itemTitles[spin]}")

                    // Calculate the closest matching value based on final rotation
                    val adjustedFinalRotation = if (finalRotation < 0) finalRotation + 360 else finalRotation
                    val segmentIndex = ((adjustedFinalRotation + degreesPerSegment / 2) / degreesPerSegment).toInt() % itemTitles.size
                    resultValue = itemTitles[segmentIndex]
                    Log.d("SpinFragment", "Adjusted Final Rotation: $adjustedFinalRotation, Segment Index: $segmentIndex, Result Value: $resultValue")

                    showResult(resultValue)
                }
            }.start()
        }
    }
}
