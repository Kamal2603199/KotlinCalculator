package com.example.kotlincalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editNo1 = findViewById<EditText>(R.id.editNo1)
        val editNo2 = findViewById<EditText>(R.id.editNo2)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val txtSum = findViewById<TextView>(R.id.txtSum)

        // Set a click listener for the button
        btnAdd.setOnClickListener {
            // Get the input values from the EditText fields
            val num1 = editNo1.text.toString()
            val num2 = editNo2.text.toString()

            // Check if both fields are not empty
            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                // Convert the input strings to integers and calculate the sum
                val sum = num1.toInt() + num2.toInt()
                Toast.makeText(this,"The sum is: $sum", Toast.LENGTH_LONG).show()
                // Display the result in the TextView
                txtSum.text = "The Sum is: $sum"
            } else {
                // Handle the case where one or both fields are empty
                txtSum.text = "Please enter both numbers"
            }
        }

        // Apply window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
