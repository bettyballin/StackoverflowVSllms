public class CustomerHeaderView : UserControl\n{\n    // ...\n\n    public CustomerHeaderView()\n    {\n        InitializeComponent();\n\n        Messenger.Default.Register<ErrorMessage>(this, (message) =>\n        {\n            // Display the error message\n        });\n    }\n}