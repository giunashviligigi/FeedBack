package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var checkboxki: CheckBox
    private lateinit var checkboxara: CheckBox
    private lateinit var saxeli: EditText
    private lateinit var gvari: EditText
    private lateinit var text1: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkboxki = findViewById(R.id.checkBoxKi)
        checkboxara = findViewById(R.id.checkBoxAra)
        saxeli = findViewById(R.id.saxeli)
        gvari = findViewById(R.id.gvari)
        text1 = findViewById(R.id.text)

        button.setOnClickListener {
            when {
                TextUtils.isEmpty(saxeli.text.toString().trim()) -> {
                    saxeli.error = "გთხოვთ შეიყვანოთ თქვენი სახელი"
                }
                TextUtils.isEmpty(gvari.text.toString().trim()) -> {
                    gvari.error = "გთხოვთ შეიყვანოთ თქვენი გვარი"
                }
                TextUtils.isEmpty(text1.text.toString().trim()) -> {
                    text1.error = "გთხოვთ შეიყვანოთ ტექსტი"
                }

                saxeli.text.toString().isNotEmpty() and gvari.text.toString().isNotEmpty() and
                        text1.text.toString().isNotEmpty() -> {
                   if (checkboxki.isChecked || checkboxara.isChecked){
                       if (saxeli.text.toString().length >= 3 ) {
                           if (gvari.text.toString().length >= 5 )  {
                               if (text1.text.toString().length >= 10) {
                                   Toast.makeText(applicationContext,"წარმატებით გაიგზავნა", Toast.LENGTH_LONG).show()
                               }
                               else {
                                   text1.error = "თქვენს მიერ შეყვანილი ტექსტი უნდა შეიცავდეს მინიმუმ 10 სიმბოლოს"
                               }
                           }
                           else {
                               gvari.error = "თვენს მიერ შეყვანილი ტექსტი უნდა შეიცავდეს მინიმუმ 5 სიმბოლოს"
                           }
                       }
                       else{
                           saxeli.error = "თვენს მიერ შეყვანილი ტექსტი უნდა შეიცავდეს მინიმუმ 3 სიმბოლოს"
                       }
                   }
                    else{
                        checkboxara.error = "მონიშნეთ CheckBox"
                   }

                }

            }
        }

    }
}