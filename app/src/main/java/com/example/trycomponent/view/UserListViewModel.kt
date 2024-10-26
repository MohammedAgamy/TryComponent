package com.example.trycomponent.view

import androidx.lifecycle.ViewModel
import com.example.trycomponent.repository.UserRepository
import com.example.trycomponent.repository.UserRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserListViewModel : ViewModel() {
    private val repo: UserRepository = UserRepositoryImpl()


    // User input fields and validation errors
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email
    private val _nameError = MutableStateFlow(false)
    val nameError: StateFlow<Boolean> = _nameError
    private val _emailError = MutableStateFlow(false)
    val emailError: StateFlow<Boolean> = _emailError

    // Update name input and validate
    fun updateName(input: String) {
        _name.value = input
        _nameError.value = input.isBlank()  // Name cannot be empty
    }

    // Update email input and validate
    fun updateEmail(input: String) {
        _email.value = input
        _emailError.value = input.isBlank() || !android.util.Patterns.EMAIL_ADDRESS.matcher(input)
            .matches()  // Check email format
    }

    // Method to add user if inputs are valid
    fun addUser() {
        if (!_nameError.value && !_emailError.value) {
            // Add user logic here
        } else {
            // Handle input errors (e.g., show a toast or a message)
        }
    }
}
