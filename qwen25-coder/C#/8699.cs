protected void MyTreeView_SelectedNodeChanged(object sender, EventArgs e)\n{\n    // Update the Literal content here based on selected node\n    MyLiteral.Text = "Content for: " + MyTreeView.SelectedNode.Value;\n}