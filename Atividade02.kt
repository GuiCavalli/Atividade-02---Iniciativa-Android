package br.unipar.primeiraatividade

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val buttonSum = findViewById<Button>(R.id.buttonSum)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        buttonSum.setOnClickListener {
            val number1 = editTextNumber1.text.toString()
            val number2 = editTextNumber2.text.toString()
            if (number1.isNotBlank() && number2.isNotBlank()) {
                try {
                    val result = number1.toDouble() + number2.toDouble()
                    textViewResult.text = "Resultado: $result"
                } catch (e: NumberFormatException) {
                    textViewResult.text = "Entrada inválida"
                }
            } else {
                textViewResult.text = "Preencha ambos os campos"
            }
        }
        buttonSubtract.setOnClickListener {
            val number1 = editTextNumber1.text.toString()
            val number2 = editTextNumber2.text.toString()
            if (number1.isNotBlank() && number2.isNotBlank()) {
                try {
                    val result = number1.toDouble() - number2.toDouble()
                    textViewResult.text = "Resultado: $result"
                } catch (e: NumberFormatException) {
                    textViewResult.text = "Entrada inválida"
                }
            } else {
                textViewResult.text = "Preencha ambos os campos"
            }
        }
    }

}




<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <EditText
        android:id="@+id/editTextNumber1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberDecimal"
        android:hint="Digite o primeiro número" />


    <EditText
        android:id="@+id/editTextNumber2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextNumber1"
        android:layout_marginTop="16dp"
        android:inputType="numberDecimal"
        android:hint="Digite o segundo número" />

    <Button
        android:id="@+id/buttonSum"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextNumber2"
        android:layout_marginTop="16dp"
        android:text="Somar" />

    <Button
        android:id="@+id/buttonSubtract"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_toRightOf="@id/buttonSum"
        android:layout_alignBaseline="@id/buttonSum"
        android:text="Subtrair" />

    <TextView
        android:id="@+id/textViewResult"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/buttonSum"
        android:layout_marginTop="16dp"
        android:textSize="18sp"
        android:text="Resultado: " />
</RelativeLayout>
