function startLongTask() {\n      $.post('/StartLongTask', { data: 'your_data' }, function(response) {\n          localStorage.setItem('taskId', response.taskId);\n          checkTaskStatus();\n      });\n  }