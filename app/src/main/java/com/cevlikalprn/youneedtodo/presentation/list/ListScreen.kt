package com.cevlikalprn.youneedtodo.presentation.list

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.Constants.ADD_TASK_ID
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreen
import com.cevlikalprn.youneedtodo.presentation.uipack.button.AppFloatingActionButton
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.AppDefaultToolbar

@Composable
fun ListScreen(
    navigateToTaskScreen: NavigateToTaskScreen
) {
    Scaffold(
        topBar = {
            AppDefaultToolbar(
                title = "Tasks",
                onSearchClick = {},
                onSortOnClick = {}
            )
        },
        floatingActionButton = {
            AppFloatingActionButton(
                iconImageVector = Icons.Filled.Add,
                onClick = {
                    navigateToTaskScreen(ADD_TASK_ID)
                }
            )
        },
        content = { paddingValues ->
            paddingValues
        }
    )
}

@Composable
@Preview
fun ListScreenPreview() {
    ListScreen(
        navigateToTaskScreen = {
            // do nothing
        }
    )
}
