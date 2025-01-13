protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)\n{\n    GridView1.PageIndex = e.NewPageIndex;\n    BindData(); // Reload with new page index\n}\n\nprivate void BindData()\n{\n    int pageSize = GridView1.PageSize;\n    int pageNumber = GridView1.PageIndex + 1; // GridView uses zero-based index\n\n    IEnumerable<YourDataType> data = GetItems(pageSize, pageNumber);\n    GridView1.DataSource = data;\n    GridView1.DataBind();\n}