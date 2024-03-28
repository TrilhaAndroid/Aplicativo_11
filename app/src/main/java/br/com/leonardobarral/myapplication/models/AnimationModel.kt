package br.com.leonardobarral.myapplication.models

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnimationModel : ViewModel() {

    private val _visible = MutableLiveData<Boolean>()
    val visible: LiveData<Boolean> = _visible

    fun updateVisible(novoValor: Boolean) {
        _visible.value = novoValor
    }


    private val _enter = MutableLiveData<EnterTransition>()
    val enter: LiveData<EnterTransition> = _enter

    fun updateEnter(novoValor: EnterTransition) {
        _enter.value = novoValor
    }


    private val _exit = MutableLiveData<ExitTransition>()
    val exit: LiveData<ExitTransition> = _exit

    fun updateExit(novoValor: ExitTransition) {
        _exit.value = novoValor
    }


}