private void Window_KeyDown(object sender, KeyEventArgs e)\n{\n    if (Keyboard.Modifiers == ModifierKeys.Windows)\n    {\n        if (e.Key == Key.E)\n        {\n            // Open a new Explorer Window\n            Process.Start("explorer.exe");\n        }\n        else if (e.Key == Key.R)\n        {\n            // Display the Run command\n            Process.Start("rundll32.exe", "shell32.dll,#61");\n        }\n    }\n}