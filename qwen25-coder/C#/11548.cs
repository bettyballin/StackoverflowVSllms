private Grid _currentVisibleGrid; // Variable to keep track of currently visible grid\n\n// Method to show a specific grid and hide the previously visible one (if any)\nprivate void ShowGrid(Grid targetGrid)\n{\n    if (_currentVisibleGrid != null && _currentVisibleGrid != targetGrid)\n    {\n        BeginStoryboard((Storyboard)this.FindResource("HideGrid"));\n    }\n    // Set the new visible grid\n    _currentVisibleGrid = targetGrid;\n    _currentVisibleGrid.Visibility = Visibility.Visible;\n}\n\n// KeyDown event handler\nprivate void Window_KeyDown(object sender, System.Windows.Input.KeyEventArgs e)\n{\n    if (e.Key == System.Windows.Input.Key.Escape && _currentVisibleGrid != null)\n    {\n        BeginStoryboard((Storyboard)this.FindResource("HideGrid"));\n        _currentVisibleGrid.Visibility = Visibility.Collapsed;\n        _currentVisibleGrid = null; // Reset the visible grid\n    }\n}