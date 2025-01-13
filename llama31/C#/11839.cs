using System;\nusing System.Windows.Forms;\n\npublic class ListViewHeaderExample : Form\n{\n    private ListView listView1;\n\n    public ListViewHeaderExample()\n    {\n        listView1 = new ListView();\n        listView1.Dock = DockStyle.Fill;\n        listView1.View = View.Details;\n\n        // Create groups\n        ListViewGroup group1 = new ListViewGroup("Template Categories");\n        ListViewGroup group2 = new ListViewGroup("Microsoft Office Online");\n\n        // Add groups to the list view\n        listView1.Groups.Add(group1);\n        listView1.Groups.Add(group2);\n\n        // Add items to the groups\n        ListViewItem item1 = new ListViewItem("Item 1");\n        item1.Group = group1;\n        listView1.Items.Add(item1);\n\n        ListViewItem item2 = new ListViewItem("Item 2");\n        item2.Group = group2;\n        listView1.Items.Add(item2);\n\n        this.Controls.Add(listView1);\n    }\n\n    [STAThread]\n    static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.SetCompatibleTextRenderingDefault(false);\n        Application.Run(new ListViewHeaderExample());\n    }\n}