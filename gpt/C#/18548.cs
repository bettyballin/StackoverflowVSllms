public partial class Form1 : Form\n{\n    public Form1()\n    {\n        InitializeComponent();\n\n        CustomDateTimePicker customDateTimePicker = new CustomDateTimePicker\n        {\n            TextBackColor = Color.Yellow,\n            Location = new Point(10, 10),\n            Size = new Size(200, 25)\n        };\n\n        this.Controls.Add(customDateTimePicker);\n    }\n}