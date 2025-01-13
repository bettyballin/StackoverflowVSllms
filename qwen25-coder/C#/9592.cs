protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        TreeView1.Nodes.Add(new TreeNode("Test 1", "Test One"));\n        TreeView1.Nodes.Add(new TreeNode("Test 2", "Test Two"));\n        TreeView1.Nodes.Add(new TreeNode("Test 3", "Test Three"));\n        TreeView1.Nodes.Add(new TreeNode("Test 4", "Test Four"));\n\n        foreach (TreeNode node in TreeView1.Nodes)\n        {\n            // Add client-side handler for click event\n            string script = "onTreeViewNodeClick();";\n            node.SelectAction = TreeNodeSelectAction.PostBack;\n            node.Attributes["onclick"] = script;\n        }\n\n        TreeView1.Nodes[0].Selected = true; // Pre-select the first node initially\n    }\n}