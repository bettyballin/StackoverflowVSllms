using System.Windows;\nusing System.IO;\n\nnamespace WpfApp\n{\n    public partial class MainWindow : Window\n    {\n        private const string SettingsFile = "settings.txt";\n        private double _rightColumnWidth = 200; // Default initial width\n\n        public MainWindow()\n        {\n            InitializeComponent();\n            LoadSettings();\n        }\n\n        private void ToggleRightColumn_Click(object sender, RoutedEventArgs e)\n        {\n            if (RightColumn.Width.Value > 0)\n            {\n                _rightColumnWidth = RightColumn.Width.Value;\n                RightColumn.Width = new GridLength(0);\n            }\n            else\n            {\n                RightColumn.Width = new GridLength(_rightColumnWidth);\n            }\n        }\n\n        private void Window_Closed(object sender, System.EventArgs e)\n        {\n            SaveSettings();\n        }\n\n        private void LoadSettings()\n        {\n            if (File.Exists(SettingsFile))\n            {\n                var sizeText = File.ReadAllText(SettingsFile);\n                if (double.TryParse(sizeText, out double savedWidth))\n                {\n                    _rightColumnWidth = savedWidth;\n                    RightColumn.Width = new GridLength(_rightColumnWidth);\n                }\n            }\n        }\n\n        private void SaveSettings()\n        {\n            File.WriteAllText(SettingsFile, _rightColumnWidth.ToString());\n        }\n    }\n}