package com.example.lstore.ui.login
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.lstore.R
import com.example.lstore.dataBase.DataBase
import com.example.lstore.databinding.ActivityLoginBinding
import com.example.lstore.ui.cart.CartActivity
import com.example.lstore.ui.register.RegisterActivity
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater)}
    lateinit var dataBase: DataBase
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setContentView(binding.root)

        dataBase = DataBase.getInstance(this)
        viewModel = LoginViewModel(dataBase)

        loginOnclick()
        setupObservers()
    }

    private fun loginOnclick() = with(binding) {
        btnLogin.setOnClickListener {
            lifecycleScope.launch { login() }
        }
    }

    private suspend fun login() = with(binding) {
        viewModel.checkRegistry(
            email = edtEmail.text.toString(),
            password = edtPassword.text.toString()
        )
    }

    private fun setupObservers(){5
        viewModel.checkRegistryStateState.observe(this,{ checkRegistry ->
           when(checkRegistry){
               LoginViewModel.CheckRegistryState.Success -> showSuccess()
               LoginViewModel.CheckRegistryState.Error -> showError()
               LoginViewModel.CheckRegistryState.Empty -> showEmptyError()
           }
        })
    }

    private fun showSuccess() {
        val intent = Intent(this, RegisterActivity::class.java).apply {}
        startActivity(intent)
    }
    private fun showError() {
        Toast.makeText(this, "Erro ao fazer Login, E-mail ou Senha invalidos ", Toast.LENGTH_LONG).show()
    }
    private fun showEmptyError() {
        Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
    }
}