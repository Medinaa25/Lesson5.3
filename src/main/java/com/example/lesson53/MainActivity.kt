package com.example.lesson53

import android.app.Application
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.lesson53.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding


class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnListener()
        onActivityResult(RESULT_OK,0,intent)
        val textValue = intent.getStringExtra("KEY")
        binding.edittext.setText(textValue)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
       val  text : String = intent.getStringExtra("KEY").toString()
        if (resultCode == RESULT_OK && requestCode == 0){
           binding.edittext.setText(text)
        }
    }


    private fun btnListener() {
        binding.button.setOnClickListener() {
            if (binding.edittext.length() <= 0) {
                Toast.makeText(
                    applicationContext,
                    "EditText не может существовать без текста!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("KEY", binding.edittext.text.toString())
                startActivity(intent)
            }

        }
    }


}