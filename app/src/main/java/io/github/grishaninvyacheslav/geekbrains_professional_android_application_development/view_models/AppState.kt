package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models

sealed class AppState {
    object Success : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}