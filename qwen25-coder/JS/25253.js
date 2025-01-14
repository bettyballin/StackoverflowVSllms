function populateTaskList(taskTypes, taskTypeToSelect) {\n    var $taskList = $('<select name="taskList" class="task-list"></select>');\n    let defaultIndexSet = false;\n\n    taskTypes.forEach((taskType, index) => {\n        const option = new Option(taskType.TaskName, taskType.TaskId);\n        \n        if (taskType.TaskName === taskTypeToSelect && !defaultIndexSet) {\n            option.selected = true;\n            defaultIndexSet = true; // Ensure only one is set as selected\n        }\n        \n        $taskList.append(option);\n    });\n\n    return $taskList;\n}\n\n// Usage inside jqGrid formatter or after row creation:\n$(document).on('click', '.task-list', function() {\n    console.log("Selected Task ID:", this.value);\n    // Handle click event here if needed\n});\n\nfunction addRowToJqGrid(gridId, rowData) {\n    const taskList = populateTaskList(result.TaskTypes, rowData.TaskType);\n    $(`#${gridId}`).jqGrid('addRowData', rowData.id, {\n        task: taskList.prop("outerHTML"),\n        // other data fields...\n    });\n}\n\n// Example call\naddRowToJqGrid('yourGridId', { id: 1, TaskType: 'YourTaskName' /* other fields */ });