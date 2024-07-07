package com.cevlikalprn.youneedtodo.presentation.screen.list

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask

data class ListUiState(
    val areTasksFetched: Boolean,
    val toDoTasks: List<ToDoTask>?,
) {

    companion object {
        val Default = ListUiState(
            areTasksFetched = false,
            toDoTasks = emptyList()
        )
    }
}
