package com.example.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import model.Formulario

class FormularioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        var selectedUF: String = "AL"
        var sexoSelecionado: String = "Masculino"
        val editTextNomeCompleto = findViewById<EditText>(R.id.editTextNomeCompleto)
        val editTextTelefone = findViewById<EditText>(R.id.editTextTelefone)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val checkBoxSalvarEmail = findViewById<CheckBox>(R.id.checkBoxSalvarEmail)
        val radioGroupSexo = findViewById<RadioGroup>(R.id.radioGroupSexo)
        val radioButtonMasculino = findViewById<RadioButton>(R.id.radioButtonMasculino)
        val radioButtonFeminino = findViewById<RadioButton>(R.id.radioButtonFeminino)
        val editTextCidade = findViewById<EditText>(R.id.editTextCidade)
        val spinnerUF = findViewById<Spinner>(R.id.spinnerUF)
        val ufs = resources.getStringArray(R.array.ufs)
        val buttonSalvar = findViewById<Button>(R.id.buttonSalvar)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ufs)
        val buttonLimpar = findViewById<Button>(R.id.buttonLimpar)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerUF.adapter = adapter


        radioGroupSexo.setOnCheckedChangeListener { _, checkedId ->
            sexoSelecionado = when (checkedId) {
                R.id.radioButtonMasculino -> "Masculino"
                R.id.radioButtonFeminino -> "Feminino"
                else -> "Masculino"
            }

            spinnerUF.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                   selectedUF = parent.getItemAtPosition(position) as String
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    selectedUF = ""
                }
            }


        buttonSalvar.setOnClickListener {
            val nomeCompleto = editTextNomeCompleto.text.toString()
            val telefone = editTextTelefone.text.toString()
            val email = editTextEmail.text.toString()
            val salvarEmail = checkBoxSalvarEmail.isChecked
            val cidade = editTextCidade.text.toString()
            val uf = selectedUF

            val formulario = Formulario(nomeCompleto, telefone, email, salvarEmail, sexoSelecionado, cidade, uf)

            val textoToast = "Nome: $nomeCompleto\nTelefone: $telefone\nEmail: $email\nSalvar Email: $salvarEmail\nSexo: $sexoSelecionado\nCidade: $cidade\nUF: $uf"
            Toast.makeText(this, textoToast, Toast.LENGTH_LONG).show()
        }

            buttonLimpar.setOnClickListener {
                editTextNomeCompleto.text.clear()
                editTextTelefone.text.clear()
                editTextEmail.text.clear()
                editTextCidade.text.clear()
                checkBoxSalvarEmail.isChecked = false
                spinnerUF.setSelection(0)
            }

        }
}
}


