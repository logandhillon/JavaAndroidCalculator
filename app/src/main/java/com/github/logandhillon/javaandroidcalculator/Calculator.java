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

import android.annotation.SuppressLint;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator {
    private final ArrayList<ExpressionElement> expression;
    private final TextView resultDisplay;
    private final TextView operationDisplay;

    public Calculator(TextView resultDisplay, TextView operationDisplay) {
        this.resultDisplay = resultDisplay;
        this.operationDisplay = operationDisplay;
        this.expression = new ArrayList<>();
    }

    @SuppressLint("SetTextI18n")
    public void pushOperand(int operand) {
        expression.add(new ExpressionElement(operand));
        if (expression.size() > 1 && expression.get(expression.size()-1).isOperand())
            resultDisplay.setText(resultDisplay.getText() + String.valueOf(operand));
        else resultDisplay.setText(String.valueOf(operand));
    }

    public void pushOperation(Operation operation) {
        expression.add(new ExpressionElement(operation));
        operationDisplay.setText(operation.toString());
    }

    public void clear(boolean clearDisplay) {
        expression.clear();
        operationDisplay.setText("");
        if (clearDisplay) resultDisplay.setText("");
    }

    public void calc() {
        // TODO: 02-01-2024
    }
}
