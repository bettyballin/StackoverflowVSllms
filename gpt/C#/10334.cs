// Create a new window instance\nWindow dialog = new Window();\n\n// Show the dialog\nbool? result = dialog.ShowDialog();\n\n// Check the result\nif (result == null)\n{\n    Console.WriteLine("Dialog result is null, DialogResult was not set.");\n}\nelse if (result == true)\n{\n    Console.WriteLine("Dialog result is true, DialogResult was set to true.");\n}\nelse\n{\n    Console.WriteLine("Dialog result is false, DialogResult was set to false.");\n}