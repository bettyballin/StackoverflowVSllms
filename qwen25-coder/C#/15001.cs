using System.Collections.Generic;\nusing System.Windows;\nusing System.Windows.Input;\nusing System.Windows.Threading;\n\npublic partial class MainWindow : Window\n{\n    private HashSet<Key> keysDown = new HashSet<Key>();\n    private double gcX = 0;\n    private double gcY = 0;\n    private DispatcherTimer timer;\n\n    public MainWindow()\n    {\n        InitializeComponent();\n\n        // Initialize the dispatcher timer\n        timer = new DispatcherTimer();\n        timer.Interval = TimeSpan.FromMilliseconds(16); // Approximately 60 FPS\n        timer.Tick += Timer_Tick;\n        timer.Start();\n\n        this.KeyDown += KeyDownHandler;\n        this.KeyUp += KeyUpHandler;\n    }\n\n    private void KeyDownHandler(object sender, KeyEventArgs e)\n    {\n        keysDown.Add(e.Key);\n    }\n\n    private void KeyUpHandler(object sender, KeyEventArgs e)\n    {\n        keysDown.Remove(e.Key);\n    }\n\n    private void Timer_Tick(object sender, EventArgs e)\n    {\n        // Update position based on held down keys\n        if (keysDown.Contains(Key.W))\n            gcY -= 5;\n        if (keysDown.Contains(Key.S))\n            gcY += 5;\n        if (keysDown.Contains(Key.A))\n            gcX -= 5;\n        if (keysDown.Contains(Key.D))\n            gcX += 5;\n\n        // Apply the transformation to the canvas\n        gameCanvas.RenderTransform = new TranslateTransform(gcX, gcY);\n    }\n}