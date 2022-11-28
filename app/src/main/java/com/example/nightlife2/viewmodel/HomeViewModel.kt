package com.example.nightlife2.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nightlife2.model.User
import com.example.nightlife2.repositories.HomeRepository
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository,
                                        private val savedStateHandle: SavedStateHandle):
    ViewModel(), LifecycleObserver {
    var loggedIn by mutableStateOf(false)
    var user = User(1, "TestUser")

    val barState by lazy {
        repository.getBars()
            .stateIn(viewModelScope, started = SharingStarted.WhileSubscribed(), emptyList())
    }

    //
    fun logIn() {
                loggedIn = !loggedIn
    }
}