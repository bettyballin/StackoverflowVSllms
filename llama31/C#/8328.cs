bool? result = dialog.ShowDialog();\nif (result ?? false) { /* accepted */ }\nelse if (result == false) { /* canceled */ }\nelse { /* closed without setting DialogResult */ }