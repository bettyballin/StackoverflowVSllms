protected void TreeView1_SelectedNodeChanged(object sender, EventArgs e)\n{\n    // Update the Literal based on the selected node\n    Literal1.Text = "New content based on the selected node.";\n}