package br.unipar.primeirasatividades

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtResultado)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultado = findViewById<TextView>(R.id.txtResultado)
        val inputIdade = findViewById<EditText>(R.id.edIdade)
        val botaoValidar = findViewById<Button>(R.id.btnIdade)

        botaoValidar.setOnClickListener {
            
            val idadeInformada = inputIdade.text.toString()

            if (idadeInformada.isNotBlank()) {
                try {
                    
                    val idadeInt = idadeInformada.toInt()
                    
                    val mensagem = when {
                        idadeInt < 18 -> "Você é menor de idade."
                        idadeInt in 18..60 -> "Você está na meia idade."
                        idadeInt > 60 -> "Você é idoso."
                        else -> "Idade inválida." 
                    }
                    
                    resultado.setText(mensagem)
                } catch (e: NumberFormatException) {
                    
                    resultado.setText("Informe uma idade válida.")
                }
            } else {
                
                resultado.setText("Informe uma idade.")
            }
            
            println("Idade Informada: $idadeInformada")
        }

    }


}








<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="354dp"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <TextView
            android:id="@+id/txtPergunta"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Qual sua idade?" />

        <EditText
            android:id="@+id/edIdade"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="number" />

        <Button
            android:id="@+id/btnIdade"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Verificar" />

        <TextView
            android:id="@+id/txtResultado"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <Button
            android:id="@+id/button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="limparValores"
            android:text="Limpar" />
    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
