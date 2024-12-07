package ru.faimizufarov.yarche.ui.screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HelloViewModel(): ViewModel() {
    private val _userNameText = MutableStateFlow<String?>(null)
    val userNameText = _userNameText.asStateFlow()

    init {
        viewModelScope.launch {
            _userNameText.value
        }
    }
}