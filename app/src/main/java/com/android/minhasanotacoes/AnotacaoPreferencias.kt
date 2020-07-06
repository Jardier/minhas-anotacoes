package com.android.minhasanotacoes

import android.content.Context
import android.content.SharedPreferences

class AnotacaoPreferencias(context : Context) {

    lateinit var context: Context;
    lateinit var preferences: SharedPreferences;
    lateinit var editor: SharedPreferences.Editor;
    val NOME_ARQUIVO = "anotacao.preferecias";
    val CHAVE_NOME = "nome";

    init {
        this.context = context;
        this.preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        this.editor = preferences.edit();
    }

    public fun salvarAnotacao(anotacao : String) {
        this.editor.putString(CHAVE_NOME, anotacao);
        this.editor.commit();
    }

    public fun recuperarAnotacao() : String {
        return preferences.getString(CHAVE_NOME,"").toString();
    }

}