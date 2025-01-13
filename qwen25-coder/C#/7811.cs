private void PopulateTree()\n{\n    var rootNode = new TreeNode("Root");\n    treeView1.Nodes.Add(rootNode);\n\n    // Simulate data retrieval\n    var rootData = GetDataFromDatabase(null);\n    foreach (var nodeData in rootData)\n    {\n        var treeNode = new TreeNode(nodeData.Name);\n        if (nodeData.HasChildren)\n        {\n            // Adding a dummy child to indicate that it can be expanded.\n            treeNode.Nodes.Add("dummy");\n        }\n        rootNode.Nodes.Add(treeNode);\n    }\n}\n\nprivate void treeView1_BeforeExpand(object sender, TreeViewCancelEventArgs e)\n{\n    if (e.Node.Nodes.Count == 1 && e.Node.Nodes[0].Text == "dummy")\n    {\n        e.Node.Nodes.Clear();\n\n        // Simulate data retrieval\n        var childrenData = GetDataFromDatabase(e.Node.Text);\n        foreach (var childNodeData in childrenData)\n        {\n            var treeNode = new TreeNode(childNodeData.Name);\n            if (childNodeData.HasChildren)\n            {\n                treeNode.Nodes.Add("dummy");\n            }\n            e.Node.Nodes.Add(treeNode);\n        }\n    }\n}\n\nprivate List<TreeNodeData> GetDataFromDatabase(string parentName)\n{\n    // Simulate database query\n    return new List<TreeNodeData>\n    {\n        // Example data items with HasChildren flag\n        new TreeNodeData{Name = "Child Node", HasChildren = false},\n        new TreeNodeData{Name = "Parent Node", HasChildren = true}\n    };\n}\n\n// Data class representation of nodes in your tree.\npublic class TreeNodeData\n{\n    public string Name { get; set; }\n    public bool HasChildren { get; set; }\n}