protected void Page_Load(object sender, EventArgs e)\n{\n    if (IsPostBack)\n    {\n        foreach (GridViewRow row in GridView1.Rows)\n        {\n            // selectively hide links in some GridView fields\n            // based on the query results\n            if (/* your condition here */)\n            {\n                row.Cells[/* cell index */].Controls[/* control index */].Visible = false;\n            }\n        }\n    }\n}