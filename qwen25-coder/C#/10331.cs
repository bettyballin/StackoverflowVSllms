protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        BindGrid();\n    }\n}\n\nprivate void BindGrid()\n{\n    // Construct query based on search criteria\n    string query = BuildDynamicQuery();\n    \n    using (SqlConnection conn = new SqlConnection(connectionString))\n    {\n        SqlDataAdapter adapter = new SqlDataAdapter(query, conn);\n        DataTable dt = new DataTable();\n        adapter.Fill(dt);\n\n        ResultGrid.DataSource = dt;\n        ResultGrid.DataBind();\n    }\n}\n\nprotected void ResultGrid_RowCommand(object sender, GridViewCommandEventArgs e)\n{\n    if (e.CommandName == "EditItem")\n    {\n        int id = Convert.ToInt32(e.CommandArgument);\n        // Redirect to the edit page and pass the ID as a query string\n        Response.Redirect("EditPage.aspx?id=" + id);\n    }\n}\n\nprivate string BuildDynamicQuery()\n{\n    // Construct your SQL query based on search parameters\n    StringBuilder sqlBuilder = new StringBuilder();\n    sqlBuilder.Append("SELECT Id, Name FROM YourTable WHERE 1=1");\n\n    if (!string.IsNullOrEmpty(txtSearchField.Text))\n    {\n        sqlBuilder.AppendFormat(" AND SomeColumn LIKE @searchTerm");\n    }\n\n    // Add more conditions as necessary...\n    \n    return sqlBuilder.ToString();\n}