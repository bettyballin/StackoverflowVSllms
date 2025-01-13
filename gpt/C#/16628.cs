public MainPage()\n{\n    InitializeComponent();\n    this.Loaded += new RoutedEventHandler(MainPage_Loaded);\n}\n\nvoid MainPage_Loaded(object sender, RoutedEventArgs e)\n{\n    // Attach a key down event handler to the root visual\n    this.KeyDown += new KeyEventHandler(MainPage_KeyDown);\n}\n\nvoid MainPage_KeyDown(object sender, KeyEventArgs e)\n{\n    // Check if the key pressed is an arrow key\n    if (e.Key == Key.Up || e.Key == Key.Down || e.Key == Key.Left || e.Key == Key.Right)\n    {\n        // Handle the arrow key press\n        e.Handled = true; // Prevent the ScrollViewer from handling the event\n        // Your custom logic here\n    }\n}