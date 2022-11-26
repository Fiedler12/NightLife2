package com.example.nightlife2.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nightlife2.model.Bar
import com.example.nightlife2.model.User
import com.example.nightlife2.repositories.HomeRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel : ViewModel() {
    var loggedIn by mutableStateOf(false)
    var user = User(1, "TestUser")

    @Inject
    lateinit var homeRepository: HomeRepository

    val barState by lazy {
        homeRepository.getBars()
            .stateIn(this.viewModelScope, started = SharingStarted.WhileSubscribed(), emptyList<Bar>())
    }

    //
    fun logIn() {
        viewModelScope.launch {
            loggedIn = !loggedIn
        }
    }
}