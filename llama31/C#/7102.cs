protected void TreeView1_SelectedNodeChanged(object sender, EventArgs e)\n{\n    // Get the selected node's CategoryID and retrieve the corresponding data\n    string categoryId = TreeView1.SelectedNode.Value;\n\n    // Load the data into a form or control for editing\n}\n\nprotected void TreeView1_NodeCommand(object sender, TreeNodeEventArgs e)\n{\n    if (e.CommandName == "Delete")\n    {\n        // Get the node's CategoryID and delete the corresponding record\n        string categoryId = e.Node.Value;\n\n        // Delete the record from the database\n    }\n}