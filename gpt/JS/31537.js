// Set focus to the editor view\nkomodo.view.setFocus();\n\n// Use a slight delay to ensure the focus is set before executing the command\nsetTimeout(function() {\n    komodo.doCommand('cmd_selectWordLeft');\n}, 100); // 100 milliseconds delay