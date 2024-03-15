import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.parouimpar.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        private fun escolhaMaquina() : Int{
            val escolha: Int = Random.nextInt(5)
            binding.textViwComputador.text = escolha.toString()
            return escolha
        }



