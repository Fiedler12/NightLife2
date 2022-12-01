package com.example.nightlife2.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nightlife2.repositories.Bar
import com.example.nightlife2.repositories.HomeRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BarViewModel @Inject constructor(private val repository: HomeRepository,
                                               private val savedStateHandle: SavedStateHandle
):
    ViewModel(), LifecycleObserver {

    var barFlow: Bar = Bar(-1, "Loading", 0.0, "Loading")

        fun fetchBar(id: Int) = viewModelScope.launch {
        repository.getBarFromDb(id).collect {
            barFlow = it
        }}
    }
