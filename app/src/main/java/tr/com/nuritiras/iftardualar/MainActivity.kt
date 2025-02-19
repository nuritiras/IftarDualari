package tr.com.nuritiras.iftardualar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import tr.com.nuritiras.iftardualar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dua1=IftarDua("1 Ramazan","Cumartesi",R.drawable.rid1)
        val dua2=IftarDua("2 Ramazan","Pazar",R.drawable.rid2)
        val dua3=IftarDua("3 Ramazan","Pazartesi",R.drawable.rid3)
        val dua4=IftarDua("4 Ramazan","Salı",R.drawable.rid4)

        val duaList=ArrayList<IftarDua>()
        duaList.add(dua1)
        duaList.add(dua2)
        duaList.add(dua3)
        duaList.add(dua4)

        val adapter=DuaAdapter(duaList)
        binding.duaRecyclerView.layoutManager= GridLayoutManager(this,2)
        binding.duaRecyclerView.adapter= adapter

    }
}