package com.dekadensiotak.hellomantan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.dekadensiotak.hellomantan.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // binding.apply{}

        // val button : Button = findViewById(R.id.btn1)
        binding.btn1.setOnClickListener {
            val name = binding.nameText.text.toString()
            val imgRes = resources.getIdentifier(name, "drawable", packageName)
            val imgDef = resources.getIdentifier("cover", "drawable", packageName)

            if(name == null || name.trim() == "") {
                Toast.makeText(
                this@MainActivity, "nama gak boleh kosong, mas", Toast.LENGTH_SHORT
                ).show()

                // default image
                img1.setImageResource(imgDef)
            } else {
                binding.textBase.setText(name)

                // change image
                binding.img1.setImageResource(imgRes)
            }
        }
    }
}
