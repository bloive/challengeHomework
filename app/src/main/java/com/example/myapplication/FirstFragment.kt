package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentFirstBinding
import com.google.gson.JsonArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: ParentRecyclerAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            val value = withContext(Dispatchers.Default) {
               //TODO
            }
        }

        init()
    }

    private fun init() {
        viewModel.initData()
        initRecycler()
        observes()

    }

    private fun initRecycler() {
        adapter = ParentRecyclerAdapter()
        binding.parentRecycler.layoutManager = LinearLayoutManager(activity)
        binding.parentRecycler.adapter = adapter
    }

    private fun observes() {
        viewModel._infoLiveData.observe(viewLifecycleOwner, {

            adapter.setData(it.data!!.toMutableList())
        })
    }
}