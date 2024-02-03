package com.cevlikalprn.youneedtodo.presentation.screen.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.cevlikalprn.youneedtodo.common.AppResult
import com.cevlikalprn.youneedtodo.common.Constants
import com.cevlikalprn.youneedtodo.common.extension.launchInIo
import com.cevlikalprn.youneedtodo.domain.useCase.GetAllTasksUseCase
import com.cevlikalprn.youneedtodo.presentation.model.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase
) : ViewModel() {

    var searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf(Constants.EMPTY_STRING)

    private val _allTasks: MutableStateFlow<ListUiState> = MutableStateFlow(ListUiState.Default)
    val allTasks: StateFlow<ListUiState> = _allTasks

    fun getAllTasks() = launchInIo {
        when (val tasks = getAllTasksUseCase()) {
            is AppResult.Success -> {
                _allTasks.update { state ->
                    state.copy(
                        success = true,
                        toDoTasks = tasks.data
                    )
                }
            }

            is AppResult.Error -> {
                _allTasks.update { state ->
                    state.copy(
                        success = false
                    )
                }
            }
        }
    }

    fun updateSearchAppBarState(state: SearchAppBarState) {
        searchAppBarState.value = state
    }

    fun updateSearchTextState(text: String) {
        searchTextState.value = text
    }
}