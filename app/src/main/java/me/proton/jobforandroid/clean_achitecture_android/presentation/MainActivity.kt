package me.proton.jobforandroid.clean_achitecture_android.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.proton.jobforandroid.clean_achitecture_android.databinding.ActivityMainBinding
import me.proton.jobforandroid.clean_achitecture_android.domain.models.SaveUserNameParam
import me.proton.jobforandroid.clean_achitecture_android.domain.models.UserName
import me.proton.jobforandroid.clean_achitecture_android.domain.usecase.GetUserNameUseCase
import me.proton.jobforandroid.clean_achitecture_android.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUserCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            binding.dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUserCase.execute(param = params)
            binding.dataTextView.text = "Save result = $result"
        }
    }
}