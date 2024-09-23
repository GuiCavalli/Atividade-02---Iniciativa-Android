package br.unipar.atividade07

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val numeroAleatorio = Random.nextInt(1, 101)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextGuess = findViewById<EditText>(R.id.editTextGuess)
        val buttonCheck = findViewById<Button>(R.id.buttonCheck)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        buttonCheck.setOnClickListener {
            val palpiteUsuario = editTextGuess.text.toString().toIntOrNull()
            textViewResult.text = when {
                palpiteUsuario == null -> "Insira um número válido."
                palpiteUsuario < numeroAleatorio -> "Muito baixo!"
                palpiteUsuario > numeroAleatorio -> "Muito alto!"
                else -> "Parabéns! Você acertou!"
            }
        }
    }
}




<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText
        android:id="@+id/editTextGuess"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Digite seu palpite"
        android:inputType="number"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

    <Button
        android:id="@+id/buttonCheck"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Verificar"
        app:layout_constraintTop_toBottomOf="@id/editTextGuess"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

    <TextView
        android:id="@+id/textViewResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@id/buttonCheck"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>

