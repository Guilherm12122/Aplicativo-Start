package com.example.app_start.ui.produto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_start.R;
import com.example.app_start.databinding.FragmentProductBinding;

public class ProductFragment extends Fragment {

    private FragmentProductBinding binding = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}