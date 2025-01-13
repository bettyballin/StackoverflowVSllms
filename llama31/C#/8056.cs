// Assuming you have a DataTable named 'dataTable' with the specified columns\n\n// Create a recursive function to build the tree\nprivate void BuildTree(TreeNodeCollection nodes, DataTable dataTable, int parentId)\n{\n    foreach (DataRow row in dataTable.Rows)\n    {\n        if (Convert.ToInt32(row["ParentID"]) == parentId)\n        {\n            TreeNode newNode = new TreeNode();\n            newNode.Text = row["CategoryName"].ToString();\n            newNode.Value = row["CategoryID"].ToString();\n\n            // Recursively add child nodes\n            BuildTree(newNode.ChildNodes, dataTable, Convert.ToInt32(row["CategoryID"]));\n\n            nodes.Add(newNode);\n        }\n    }\n}\n\n// Bind the Treeview control to the DataTable\nprotected void Page_Load(object sender, EventArgs e)\n{\n    DataTable dataTable = // retrieve your DataTable here\n\n    TreeView1.Nodes.Clear();\n    BuildTree(TreeView1.Nodes, dataTable, 0); // assuming 0 is the root node's ParentID\n}