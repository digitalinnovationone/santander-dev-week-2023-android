package dio.me.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dio.me.data.model.Response
import dio.me.data.network.repository.AccountRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AccountRepository,
) : ViewModel() {

    // backing property @see: https://kotlinlang.org/docs/properties.html#backing-properties
    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state

    init {
        getAccount()
    }

    private fun getAccount() = viewModelScope.launch {
        if (_state.value.response != null) return@launch

        _state.value = state.value.copy(loading = true)
        runCatching {
            withContext(Dispatchers.IO) {
                repository.getAccount()
            }
        }.onSuccess { response ->
            _state.value = MainState(loading = false, response = response)
        }.onFailure {
            it.printStackTrace()
            // todo handle error
        }
    }
}

data class MainState(
    val loading: Boolean = false,
    val response: Response? = null,
)
