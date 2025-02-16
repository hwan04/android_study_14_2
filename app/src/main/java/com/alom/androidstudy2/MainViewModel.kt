package com.alom.androidstudy2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: ItemRepository) : ViewModel() {
    private var _currentItem = MutableStateFlow<List<Data>>(emptyList())

    val currentData: StateFlow<List<Data>>
        get() = _currentItem.asStateFlow()

    init {              // 뷰모델이 실행될때 싫행
        updateValue()
    }

    fun updateValue() {
        viewModelScope.launch {
            val item = repository.getItem()
            _currentItem.emit(item)             // 불러온 데이터 emit
        }
    }

    fun addValue(item: itemRequest){
        viewModelScope.launch {
            repository.addItem(item)
        }
    }
}