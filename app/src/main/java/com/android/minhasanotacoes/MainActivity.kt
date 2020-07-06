package com.android.minhasanotacoes

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var editTextAnotacao: EditText
    lateinit var preferencias : AnotacaoPreferencias;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        editTextAnotacao = findViewById(R.id.editTextAnotacao);
        preferencias = AnotacaoPreferencias(applicationContext);


        fab.setOnClickListener { view ->
            var anotacao = editTextAnotacao.text.toString()
            if(anotacao.equals("")) {
                Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_LONG).show();
                preferencias.salvarAnotacao(anotacao);

            } else {
                preferencias.salvarAnotacao(anotacao);
                Snackbar.make(view, "Anotação salva com sucesso", Snackbar.LENGTH_LONG).show();
            }
        }

        //Recuperando anotação caso exista
        val anotacao = preferencias.recuperarAnotacao();
        if(!anotacao.equals("")) {
            editTextAnotacao.setText(anotacao);
        }
    }

}
