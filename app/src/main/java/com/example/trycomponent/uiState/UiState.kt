package com.example.trycomponent.uiState

import com.example.trycomponent.Model.Users

sealed class UiState {
    object Loading : UiState()  // Represents the loading state
    data class Success(val users: List<Users>, val message: String = "") : UiState()  // Represents a successful data fetch
    data class Error(val message: String) : UiState()  // Represents an error state with an error message
}