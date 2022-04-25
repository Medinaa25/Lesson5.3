package com.example.lesson53

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.lifecycle.LifecycleObserver
import com.example.lesson53.databinding.ActivitySecondBinding
import java.util.*
class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    private lateinit var observer : MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textValue = intent.getStringExtra("KEY")
        binding.edittext2.setText(textValue)
        buttonListener()
        
    }

    private fun buttonListener (){
        binding.button2.setOnClickListener(){
            if (binding.edittext2.length() <= 0){
                Toast.makeText(applicationContext, "EditText не может существовать без текста!", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                setResult(RESULT_OK,intent)
                intent.putExtra("KEY", binding.edittext2.text.toString())
                startActivityForResult(intent,0)
            }
        }
    }



}