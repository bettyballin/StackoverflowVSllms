protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        TreeView1.ExpandDepth = 1; // Adjust as necessary\n    }\n}\n\nprotected void TreeView1_TreeNodeDataBound(object sender, TreeNodeEventArgs e)\n{\n    // Add client-side click event to each node\n    e.Node.NavigateUrl = "javascript:nodeClicked('" + e.Node.NavigateUrl + "')";\n}