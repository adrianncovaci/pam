package com.example.lab2.presentation.detailView.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab2.databinding.FragmentGraphBinding

class GraphFragment : Fragment() {
    private lateinit var binding: FragmentGraphBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentGraphBinding.inflate(inflater)

        return binding.root
    }

}
