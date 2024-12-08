package ru.faimizufarov.yarche.ui.screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.faimizufarov.yarche.data.models.Name
import ru.faimizufarov.yarche.data.repository.YarcheRepository
import javax.inject.Inject

@HiltViewModel
class HelloViewModel @Inject constructor(
    private val yarcheRepository: YarcheRepository
): ViewModel() {
    private val _userNameText = MutableStateFlow<String?>(null)
    val userNameText = _userNameText.asStateFlow()

    init {
        viewModelScope.launch {
            _userNameText.value = yarcheRepository.getUserName()?.name
        }
    }

    fun saveUserName(name: Name) {
        viewModelScope.launch {
            yarcheRepository.saveUserName(name)
        }
    }
}