public class RichDataGridView : DataGridView\n{\n    public RichDataGridView()\n    {\n        DefaultCellStyle = new DataGridViewCellStyle { CellType = typeof(RichTextBoxCell) };\n    }\n}\n\npublic class RichTextBoxCell : DataGridViewTextBoxCell\n{\n    public override void InitializeEditingControl(int rowIndex, object initialFormattedValue, DataGridViewCellStyle dataGridViewCellStyle)\n    {\n        var richTextBox = new RichTextBox\n        {\n            Dock = DockStyle.Fill,\n            Text = initialFormattedValue.ToString(),\n            Multiline = true,\n            ReadOnly = true\n        };\n        Controls.Add(richTextBox);\n    }\n}