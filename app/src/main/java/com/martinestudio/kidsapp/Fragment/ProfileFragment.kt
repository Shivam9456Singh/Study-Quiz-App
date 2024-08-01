package com.martinestudio.kidsapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.martinestudio.kidsapp.R
import com.martinestudio.kidsapp.Withdrawal
import com.martinestudio.kidsapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    val binding by lazy {
        FragmentProfileBinding.inflate(layoutInflater)
    }
    var isExpand = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

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
        binding.headlinearLayout.setOnClickListener {
            if (isExpand) {
                binding.expandableConstraintLayout.visibility = View.VISIBLE
                binding.arrowDown.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
            } else {
                binding.expandableConstraintLayout.visibility = View.GONE
                binding.arrowDown.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)

            }
            isExpand = !isExpand

        }
        return binding.root
    }

    companion object {

    }
}