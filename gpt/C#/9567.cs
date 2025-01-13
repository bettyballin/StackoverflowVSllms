using System;\nusing System.Drawing;\nusing System.Windows.Forms;\n\npublic class MultiLineTreeView : Form\n{\n    private TreeView treeView1;\n\n    public MultiLineTreeView()\n    {\n        treeView1 = new TreeView();\n        treeView1.Dock = DockStyle.Fill;\n        treeView1.DrawMode = TreeViewDrawMode.OwnerDrawText;\n        treeView1.DrawNode += treeView1_DrawNode;\n        treeView1.Nodes.Add(CreateNode("Node 1", "Line 1\nLine 2\nLine 3"));\n        treeView1.Nodes.Add(CreateNode("Node 2", "Line 1\tColumn 2"));\n        this.Controls.Add(treeView1);\n    }\n\n    private TreeNode CreateNode(string key, string text)\n    {\n        TreeNode node = new TreeNode(key);\n        node.Tag = text;\n        return node;\n    }\n\n    private void treeView1_DrawNode(object sender, DrawTreeNodeEventArgs e)\n    {\n        string text = e.Node.Tag as string;\n        if (text != null)\n        {\n            e.Graphics.DrawString(text, treeView1.Font, Brushes.Black, e.Bounds);\n        }\n        else\n        {\n            e.DrawDefault = true;\n        }\n    }\n\n    [STAThread]\n    public static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.Run(new MultiLineTreeView());\n    }\n}