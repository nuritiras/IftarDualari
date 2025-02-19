package tr.com.nuritiras.iftardualar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import tr.com.nuritiras.iftardualar.databinding.ActivityDuaBinding

class DuaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDuaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDuaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val selectedDua=intent.getParcelableExtra<IftarDua>("ramazan",IftarDua::class.java)
        if (selectedDua != null) {
            binding.textViewRamazan.text = selectedDua.ramazan
            binding.textViewGun.text = selectedDua.gun
            binding.imageViewDua.setImageResource(selectedDua.resim)
        }
    }
}