package br.unipar.atividade04

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
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTextoValorEmReais = findViewById<EditText>(R.id.etValorEmReais)
        val editTextoTaxaConversao = findViewById<EditText>(R.id.etTaxaConversao)
        val botaoConverter = findViewById<Button>(R.id.btnConverter)
        val textoResultado = findViewById<TextView>(R.id.tvResultado)

        botaoConverter.setOnClickListener {
            val textoValorEmReais = editTextoValorEmReais.text.toString()
            val textoTaxaConversao = editTextoTaxaConversao.text.toString()

            if (textoValorEmReais.isNotEmpty() && textoTaxaConversao.isNotEmpty()) {
                try {
                    val valorEmReais = textoValorEmReais.toDouble()
                    val taxaConversao = textoTaxaConversao.toDouble()
                    val valorConvertido = valorEmReais / taxaConversao
                    textoResultado.text = String.format("Resultado: %.2f USD", valorConvertido)
                } catch (e: NumberFormatException) {
                    textoResultado.text = "Erro: Valor ou taxa inválidos"
                }
            } else {
                textoResultado.text = "Por favor, preencha todos os campos"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barrasDeSistema = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barrasDeSistema.left, barrasDeSistema.top, barrasDeSistema.right, barrasDeSistema.bottom)
            insets
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

    <EditText
        android:id="@+id/etValorEmReais"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Valor em Reais"
        android:inputType="numberDecimal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@+id/etTaxaConversao"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginStart="16dp" />

    <EditText
        android:id="@+id/etTaxaConversao"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Taxa de Conversão (R$ para $)"
        android:inputType="numberDecimal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/etValorEmReais"
        app:layout_constraintBottom_toTopOf="@+id/btnConverter"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginStart="16dp" />

    <Button
        android:id="@+id/btnConverter"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Converter"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/etTaxaConversao"
        app:layout_constraintBottom_toTopOf="@+id/tvResultado"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginStart="16dp" />

    <TextView
        android:id="@+id/tvResultado"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Resultado"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/btnConverter"
        app:layout_constraintBottom_toBottomOf="parent"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginStart="16dp" />

</androidx.constraintlayout.widget.ConstraintLayout>
