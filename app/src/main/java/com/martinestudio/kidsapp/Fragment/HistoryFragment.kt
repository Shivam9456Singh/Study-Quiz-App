package com.martinestudio.kidsapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.martinestudio.kidsapp.R
import com.martinestudio.kidsapp.Withdrawal
import com.martinestudio.kidsapp.adapter.HistoryAdapter
import com.martinestudio.kidsapp.databinding.FragmentHistoryBinding
import com.martinestudio.kidsapp.model.HistoryModelClass

class HistoryFragment : Fragment() {
    val binding by lazy{
        FragmentHistoryBinding.inflate(layoutInflater)
    }
    private var listHistory = ArrayList<HistoryModelClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listHistory.add(HistoryModelClass("12:03","+200"))
        listHistory.add(HistoryModelClass( "2:13","+100"))
        listHistory.add(HistoryModelClass("5:24","+50"))
        listHistory.add(HistoryModelClass("1:05","+500"))
        listHistory.add(HistoryModelClass("12:03","+200"))
        listHistory.add(HistoryModelClass( "2:13","+100"))
        listHistory.add(HistoryModelClass("5:24","+50"))
        listHistory.add(HistoryModelClass("1:05","+500"))
        listHistory.add(HistoryModelClass("1:05","+500"))
        listHistory.add(HistoryModelClass("1:05","+500"))
        listHistory.add(HistoryModelClass("1:05","+500"))
        listHistory.add(HistoryModelClass("1:05","+500"))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding.HistoryRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        var adapter = HistoryAdapter(listHistory)
        binding.HistoryRecyclerView.adapter = adapter
        binding.HistoryRecyclerView.setHasFixedSize(true)
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

    companion object {

    }
}