using System.Windows;\nusing System.Windows.Controls;\nusing System.Windows.Documents;\n\npublic partial class MainWindow : Window\n{\n    public MainWindow()\n    {\n        InitializeComponent();\n\n        TextBlock textBlock = new TextBlock();\n\n        // Add initial text with a placeholder\n        string initialText = "This is a sample text with a [dropdown] placeholder.";\n        textBlock.Inlines.Add(initialText);\n\n        // Find the placeholder and replace it with a ComboBox\n        ReplacePlaceholderWithComboBox(textBlock, "[dropdown]");\n        \n        this.Content = textBlock;\n    }\n\n    private void ReplacePlaceholderWithComboBox(TextBlock textBlock, string placeholder)\n    {\n        string text = new TextRange(textBlock.ContentStart, textBlock.ContentEnd).Text;\n        int placeholderIndex = text.IndexOf(placeholder);\n\n        if (placeholderIndex >= 0)\n        {\n            TextPointer start = textBlock.ContentStart.GetPositionAtOffset(placeholderIndex);\n            TextPointer end = start.GetPositionAtOffset(placeholder.Length);\n\n            if (start != null && end != null)\n            {\n                TextRange range = new TextRange(start, end);\n                range.Text = string.Empty;\n\n                ComboBox comboBox = new ComboBox\n                {\n                    Width = 100\n                };\n                comboBox.Items.Add(new ComboBoxItem { Content = "Option 1" });\n                comboBox.Items.Add(new ComboBoxItem { Content = "Option 2" });\n                comboBox.Items.Add(new ComboBoxItem { Content = "Option 3" });\n\n                InlineUIContainer container = new InlineUIContainer(comboBox) { BaselineAlignment = BaselineAlignment.Center };\n                textBlock.Inlines.InsertAfter(range.End, container);\n            }\n        }\n    }\n}