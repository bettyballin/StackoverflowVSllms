private async void Button_Click(object sender, RoutedEventArgs e)\n{\n    await Task.Run(() =>\n    {\n        // Load tree view here\n    });\n    Application.Current.Dispatcher.Invoke(DispatcherPriority.Normal, (Action)(() => OnPropertyChanged("Text")));\n}