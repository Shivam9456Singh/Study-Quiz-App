package com.martinestudio.kidsapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.martinestudio.kidsapp.R
import com.martinestudio.kidsapp.Withdrawal
import com.martinestudio.kidsapp.adapter.categoryadapter
import com.martinestudio.kidsapp.databinding.FragmentHomeBinding
import com.martinestudio.kidsapp.model.categoryModelClass


class HomeFragment : Fragment() {
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private var categoryList = ArrayList<categoryModelClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding.coinWithdrawalImage.setOnClickListener{
            val bottomSheetDialog:BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"Test")
            bottomSheetDialog.enterTransition
        }
        binding.coinWithdrawalCount.setOnClickListener{
            val bottomSheetDialog:BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"Test")
            bottomSheetDialog.enterTransition
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryList.add(categoryModelClass(R.drawable.science,"Science"))
        categoryList.add(categoryModelClass(R.drawable.maths,"Maths"))
        categoryList.add(categoryModelClass(R.drawable.english,"English"))
        categoryList.add(categoryModelClass(R.drawable.historyimage,"History"))
        categoryList.add(categoryModelClass(R.drawable.geography,"Geography"))
        categoryList.add(categoryModelClass(R.drawable.politicalscience,"Political Sci."))
        categoryList.add(categoryModelClass(R.drawable.physics,"Physics"))
        categoryList.add(categoryModelClass(R.drawable.chemistry,"Chemistry"))
        categoryList.add(categoryModelClass(R.drawable.biology,"Biology"))
        categoryList.add(categoryModelClass(R.drawable.gk,"General Knowledge"))

        binding.categoryRecyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        var adapter = categoryadapter(categoryList,requireActivity())
        binding.categoryRecyclerView.adapter = adapter
        binding.categoryRecyclerView.setHasFixedSize(true)
    }

    companion object {

    }
}