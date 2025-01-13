// Assuming you have a DataSet named 'ds' with two tables: 'Categories' and 'Products'\n// and a relation between them named 'Cat_Prod_Relation'\n\n// Create a DataRelation between the two tables\nDataRelation relation = new DataRelation("Cat_Prod_Relation",\n    ds.Tables["Categories"].Columns["CategoryID"],\n    ds.Tables["Products"].Columns["CategoryID"]);\n\n// Add the relation to the DataSet\nds.Relations.Add(relation);\n\n// Create a recursive function to build the TreeView nodes\nprivate void BuildTreeView(TreeNodeCollection nodes, DataTable table, DataRelation relation)\n{\n    foreach (DataRow row in table.Rows)\n    {\n        TreeNode node = new TreeNode(row["CategoryName"].ToString());\n        nodes.Add(node);\n\n        if (relation != null)\n        {\n            DataRow[] childRows = row.GetChildRows(relation);\n            if (childRows.Length > 0)\n            {\n                BuildTreeView(node.ChildNodes, childRows.CopyToDataTable(), null);\n            }\n        }\n    }\n}\n\n// Bind the DataSet to the TreeView\nprotected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        TreeView1.Nodes.Clear();\n        BuildTreeView(TreeView1.Nodes, ds.Tables["Categories"], ds.Relations["Cat_Prod_Relation"]);\n        TreeView1.DataBind();\n    }\n}