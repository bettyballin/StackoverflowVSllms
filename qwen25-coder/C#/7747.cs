protected void btnRefresh_Click(object sender, EventArgs e)\n{\n    // Refresh data here\n    BindGrid();\n}\n\nprivate void BindGrid()\n{\n    // Example binding logic\n    GridView1.DataSource = GetData(); // Assume GetData() fetches your data\n    GridView1.DataBind();\n}