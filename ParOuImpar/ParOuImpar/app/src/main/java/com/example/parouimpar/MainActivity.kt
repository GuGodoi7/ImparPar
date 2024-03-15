package com.example.parouimpar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.parouimpar.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private var valorPlayer: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            textView1.setOnClickListener { setPlayerValue(1) }
            textView2.setOnClickListener { setPlayerValue(2) }
            textView3.setOnClickListener { setPlayerValue(3) }
            textView4.setOnClickListener { setPlayerValue(4) }
            textView5.setOnClickListener { setPlayerValue(5) }

            textViewPar.setOnClickListener { calcularResultado("Par", valorPlayer) }
            textViewImpar.setOnClickListener { calcularResultado("Ímpar", valorPlayer) }
        }
    }

    private fun setPlayerValue(value: Int) {
        valorPlayer = value
        binding.numeroTextView.text = value.toString()
    }

    private fun calcularResultado(escolhaParOuImpar: String, escolhaPlayer: Int?) {
        if (escolhaPlayer != null) {
            val escolhaPC = Random.nextInt(5)
            binding.textViewComputer.text = escolhaPC.toString()
            val soma = escolhaPlayer + escolhaPC
            val resultado = if ((soma % 2 == 0 && escolhaParOuImpar == "Par") || (soma % 2 != 0 && escolhaParOuImpar == "Ímpar")) {
                "Você Ganhou!!"
            } else {
                "Você Perdeu..."
            }
            binding.TextViewresultado.text = resultado
            showToast(resultado)
        } else {
            showToast("Escolha um número primeiro...")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
