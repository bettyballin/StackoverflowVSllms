void MainStudioWindowControl_Loaded(object sender, System.Windows.RoutedEventArgs e)\n{\n    System.Windows.Window mainWindow = System.Windows.Application.Current.MainWindow;\n    mainWindow.WindowStartupLocation = System.Windows.WindowStartupLocation.Manual;\n    if (Studio.Properties.Settings.Default.Width > 0)\n    {\n        Rect restoreBounds = new Rect(\n            Studio.Properties.Settings.Default.Left,\n            Studio.Properties.Settings.Default.Top,\n            Studio.Properties.Settings.Default.Width,\n            Studio.Properties.Settings.Default.Height);\n        mainWindow.RestoreBounds = restoreBounds;\n    }\n    Debug.WriteLine(string.Format("Loading: Top = {0}", this.Top));\n}\n\nprotected override void OnClosing(System.ComponentModel.CancelEventArgs e)\n{\n    base.OnClosing(e);\n    System.Windows.Window mainWindow = System.Windows.Application.Current.MainWindow;\n    Rect restoreBounds = mainWindow.RestoreBounds;\n    Studio.Properties.Settings.Default.Left = restoreBounds.Left;\n    Studio.Properties.Settings.Default.Top = restoreBounds.Top;\n    Studio.Properties.Settings.Default.Width = restoreBounds.Width;\n    Studio.Properties.Settings.Default.Height = restoreBounds.Height;\n    Studio.Properties.Settings.Default.Save();\n    Debug.WriteLine(string.Format("Saving: Settings.Top = {0}", Studio.Properties.Settings.Default.Top));\n}