package com.qcoom.testzaynax.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.qcoom.testzaynax.R
import com.qcoom.testzaynax.databinding.FragmentDataBinding
import com.qcoom.testzaynax.ui.main.adapter.DataAdapter
import com.qcoom.testzaynax.ui.main.viewmodel.DataViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DataFragment : Fragment() {
    private lateinit var binding: FragmentDataBinding
    private lateinit var viewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        initData()
    }

    private fun initData(){
//
        val adapter = DataAdapter()
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvData.layoutManager = layoutManager
        binding.rvData.adapter = adapter
        adapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.Loading -> {
                    binding.progressBarNotification.visibility = View.VISIBLE
                }
                is LoadState.Error -> {
                    binding.progressBarNotification.visibility = View.GONE
                    Toast.makeText(activity, (it.source.refresh as LoadState.Error).error.localizedMessage, Toast.LENGTH_SHORT).show()
                }
                else -> {
                    binding.progressBarNotification.visibility = View.GONE
                }
            }
        }

        lifecycleScope.launch {
            viewModel.getData().collectLatest {
                adapter.submitData(viewLifecycleOwner.lifecycle,it)
            }
        }
    }
}