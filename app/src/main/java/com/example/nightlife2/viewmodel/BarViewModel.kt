package com.example.nightlife2.viewmodel

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
import javax.inject.Inject

@HiltViewModel
class BarViewModel @Inject constructor(private val repository: HomeRepository,
                                               private val savedStateHandle: SavedStateHandle
):
    ViewModel(), LifecycleObserver {

}