using System;\nusing System.Collections.Generic;\nusing System.Linq;\nusing System.Windows.Forms;\n\npublic class MyClass\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n}\n\npublic partial class MainForm : Form\n{\n    private BindingList<MyClass> _myItems = new BindingList<MyClass>();\n\n    public MainForm()\n    {\n        InitializeComponent();\n        myDataGridView.DataSource = _myItems;\n\n        // Assuming DataGridView is populated with data, convert it back to List<MyClass>\n        var items = ConvertDataGridViewToObjects(myDataGridView);\n    }\n\n    private List<MyClass> ConvertDataGridViewToObjects(DataGridView dataGridView)\n    {\n        return (from DataGridViewRow row in dataGridView.Rows\n                select new MyClass\n                {\n                    Id = Convert.ToInt32(row.Cells["IdColumn"].Value),\n                    Name = Convert.ToString(row.Cells["NameColumn"].Value)\n                }).ToList();\n    }\n}