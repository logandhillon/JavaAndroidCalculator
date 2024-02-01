/*
 * JavaAndroidCalculator
 * Copyright (C) 2024 Logan Dhillon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.logandhillon.javaandroidcalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.logandhillon.javaandroidcalculator.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    private Calculator calculator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calculator = new Calculator(binding.outResult, binding.outOperation);

        binding.numpad1.setOnClickListener(v -> calculator.pushOperand(1));
        binding.numpad2.setOnClickListener(v -> calculator.pushOperand(2));
        binding.numpad3.setOnClickListener(v -> calculator.pushOperand(3));
        binding.numpad4.setOnClickListener(v -> calculator.pushOperand(4));
        binding.numpad5.setOnClickListener(v -> calculator.pushOperand(5));
        binding.numpad6.setOnClickListener(v -> calculator.pushOperand(6));
        binding.numpad7.setOnClickListener(v -> calculator.pushOperand(7));
        binding.numpad8.setOnClickListener(v -> calculator.pushOperand(8));
        binding.numpad9.setOnClickListener(v -> calculator.pushOperand(9));

        binding.numpadAdd.setOnClickListener(v -> calculator.pushOperation(Operation.ADD));
        binding.numpadSub.setOnClickListener(v -> calculator.pushOperation(Operation.SUB));
        binding.numpadMult.setOnClickListener(v -> calculator.pushOperation(Operation.MULT));
        binding.numpadDiv.setOnClickListener(v -> calculator.pushOperation(Operation.DIV));

        binding.numpadC.setOnClickListener(v -> calculator.clear(true));
        binding.numpadEquals.setOnClickListener(v -> calculator.calc());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        calculator = null;
        binding = null;
    }
}
