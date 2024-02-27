package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.common.Constants.ADD_TASK_ID
import com.cevlikalprn.youneedtodo.data.mapper.TaskMapper
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetSelectedTaskUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository,
    private val taskMapper: TaskMapper
) {

    operator fun invoke(taskId: Int): Flow<ToDoTask> {
        if (taskId == ADD_TASK_ID) {
            return flow { emit(ToDoTask.NewToDoTask) }
        }
        return toDoRepository.getSelectedTask(taskId).map { value: ToDoTaskEntity? ->
            value?.let {
                taskMapper(it)
            } ?: run {
                ToDoTask.NewToDoTask
            }
        }
    }
}