using System;\nusing System.Collections.Generic;\nusing System.IO;\nusing System.Windows.Forms;\n\npublic class FileTreeBuilder\n{\n    public static void BuildTreeView(TreeView treeView, List<string> filePaths)\n    {\n        // Clear existing nodes\n        treeView.Nodes.Clear();\n\n        foreach (var path in filePaths)\n        {\n            string[] directories = path.Split(Path.DirectorySeparatorChar);\n            TreeNode currentNode = null;\n\n            foreach (string dir in directories)\n            {\n                if (!string.IsNullOrEmpty(dir))\n                {\n                    var matchedNode = currentNode == null \n                        ? treeView.Nodes.Cast<TreeNode>().FirstOrDefault(n => n.Text == dir) \n                        : currentNode.Nodes.Cast<TreeNode>().FirstOrDefault(n => n.Text == dir);\n\n                    if (matchedNode == null)\n                    {\n                        matchedNode = new TreeNode(dir);\n                        if (currentNode == null)\n                            treeView.Nodes.Add(matchedNode); // root node\n                        else\n                            currentNode.Nodes.Add(matchedNode);\n                    }\n\n                    currentNode = matchedNode;\n                }\n            }\n        }\n    }\n}\n\n// Usage example in a Form\npublic class MainForm : Form\n{\n    public MainForm()\n    {\n        var filePaths = new List<string>\n        {\n            "C:/WINDOWS/Temp/ErrorLog.txt",\n            "C:/Program Files/FileZilla/GPL.html",\n            "C:/Documents and Settings/Administrator/ntuser.dat.LOG"\n        };\n\n        TreeView treeView = new TreeView\n        {\n            Dock = DockStyle.Fill\n        };\n        this.Controls.Add(treeView);\n\n        FileTreeBuilder.BuildTreeView(treeView, filePaths);\n    }\n\n    [STAThread]\n    static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.SetCompatibleTextRenderingDefault(false);\n        Application.Run(new MainForm());\n    }\n}