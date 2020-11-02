package com.delet_dis.neumorphismcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ceil
import kotlin.math.floor

public var operation = "";
public var val1 = 0.0;
public var val2 = 0.0;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clearDisplay()



        ac_button.setOnClickListener {
            clearDisplay()
        }

        zero_button.setOnClickListener {
            calculator_display_non_mock.text =
                calculator_display_non_mock.text.toString() + "0"
        }

        one_button.setOnClickListener {
            calculator_display_non_mock.text =
                calculator_display_non_mock.text.toString() + "1"
        }
        two_button.setOnClickListener {
            calculator_display_non_mock.text =
                calculator_display_non_mock.text.toString() + "2"
        }
        three_button.setOnClickListener {
            calculator_display_non_mock.text =
                calculator_display_non_mock.text.toString() + "3"
        }
        four_button.setOnClickListener {
            calculator_display_non_mock.text =
                calculator_display_non_mock.text.toString() + "4"
        }
        five_button.setOnClickListener {
            calculator_display_non_mock.text =
                calculator_display_non_mock.text.toString() + "5"
        }
        six_button.setOnClickListener {
            calculator_display_non_mock.text =
                calculator_display_non_mock.text.toString() + "6"
        }
        seven_button.setOnClickListener {
            calculator_display_non_mock.text =
                calculator_display_non_mock.text.toString() + "7"
        }
        eight_button.setOnClickListener {
            calculator_display_non_mock.text =
                calculator_display_non_mock.text.toString() + "8"
        }
        nine_button.setOnClickListener {
            calculator_display_non_mock.text =
                calculator_display_non_mock.text.toString() + "9"
        }

        comma_button.setOnClickListener {
            calculator_display_non_mock.text =
                calculator_display_non_mock.text.toString() + ","
        }

        divide_button.setOnClickListener {
            val1 = calculator_display_non_mock.text.toString().replace(',', '.').toDouble()
            calculator_display_non_mock.text = ""
            operation = "DIVIDE"
        }

        multiply_button.setOnClickListener {
            val1 = calculator_display_non_mock.text.toString().replace(',', '.').toDouble()
            calculator_display_non_mock.text = ""
            operation = "MULTIPLY"
        }

        minus_button.setOnClickListener {
            val1 = calculator_display_non_mock.text.toString().replace(',', '.').toDouble()
            calculator_display_non_mock.text = ""
            operation = "MINUS"
        }

        plus_button.setOnClickListener {
            val1 = calculator_display_non_mock.text.toString().replace(',', '.').toDouble()
            calculator_display_non_mock.text = ""
            operation = "PLUS"
        }

        equals_button.setOnClickListener {
            val2 = calculator_display_non_mock.text.toString().replace(',', '.').toDouble()
            calculator_display_non_mock.text =
                if ((floor(calculateExpression()) == ceil(calculateExpression()))) calculateExpression()
                    .toString().replace(".0", "") else calculateExpression().toString()
                    .replace(',', '.')
        }

    }

    private fun clearDisplay() {
        calculator_display_non_mock.text = ""
        operation = ""
        val1 = 0.0
        val2 = 0.0
    }


    private fun calculateExpression(): Double {
        return when (operation) {
            "DIVIDE" -> val1 / val2
            "MULTIPLY" -> val1 * val2
            "MINUS" -> val1 - val2
            "PLUS" -> val1 + val2
            else -> val1
        }
    }
}