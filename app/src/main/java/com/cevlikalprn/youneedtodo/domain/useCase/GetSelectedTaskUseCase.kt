package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.common.Constants.ADD_TASK_ID
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import javax.inject.Inject

class GetSelectedTaskUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {

    operator fun invoke(taskId: Int): ToDoTask? {
        if (taskId == ADD_TASK_ID) {
            return null
        }
        return toDoRepository.getSelectedTask(taskId)
    }
}