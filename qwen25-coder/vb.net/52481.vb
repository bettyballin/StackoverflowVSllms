' Setting the CurrentUser when logging in\nGlobalVariables.CurrentUser = New User(username, userId)\n\n' Accessing the CurrentUser wherever needed\nIf GlobalVariables.CurrentUser IsNot Nothing Then\n    MessageBox.Show($"Logged in as: {GlobalVariables.CurrentUser.Username}")\nEnd If