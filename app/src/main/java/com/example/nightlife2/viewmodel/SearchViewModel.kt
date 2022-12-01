package com.example.nightlife2.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nightlife2.repositories.Bar
import com.example.nightlife2.repositories.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: HomeRepository,
                                          private val savedStateHandle: SavedStateHandle
):
    ViewModel(), LifecycleObserver {

    var barFlow: List<Bar> = emptyList()

    fun fetchMatches(query: String) = viewModelScope.launch {
        println("received search")
        repository.searchForBar(query).collect {
            barFlow = it
            println(it.size)
        }
    }

}