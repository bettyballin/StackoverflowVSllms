AppUpdater updater = new AppUpdater(@"\\network\share\path", @"C:\local\app\path\app.exe");\nif (updater.UpdateApp())\n{\n    updater.LaunchApp();\n}