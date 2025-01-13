using System.Windows;\nusing System.Windows.Controls;\nusing Microsoft.Windows.Controls;\n\nnamespace SilverlightApp\n{\n    public partial class MainPage : UserControl\n    {\n        public MainPage()\n        {\n            InitializeComponent();\n\n            // Create a data grid using the Silverlight Toolkit\n            var dataGrid = new DataGrid();\n            dataGrid.ItemsSource = new[] { new { Name = "John", Age = 30 }, new { Name = "Jane", Age = 25 } };\n            LayoutRoot.Children.Add(dataGrid);\n        }\n    }\n}