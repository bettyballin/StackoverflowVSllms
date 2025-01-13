protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)\n{\n    GridViewRow row = GridView1.SelectedRow;\n    Label1.Text = row.Cells[1].Text;\n\n    // Logging to console\n    System.Diagnostics.Debug.WriteLine("GridView1_SelectedIndexChanged triggered with project: " + Label1.Text);\n\n    using (OleDbConnection myConnection = new OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=" + dbpath + "/secure_user/data/data.mdb"))\n    {\n        string query = "SELECT tasks.Task,tasks.Priority,tasks.Done,taska.Hours FROM projects INNER JOIN tasks ON projects.Project = tasks.Project WHERE tasks.Username=@Username AND tasks.Project=@Project";\n        using (OleDbDataAdapter adapter = new OleDbDataAdapter(query, myConnection))\n        {\n            adapter.SelectCommand.Parameters.AddWithValue("@Username", uname);\n            adapter.SelectCommand.Parameters.AddWithValue("@Project", Label1.Text);\n            DataTable table = new DataTable();\n            adapter.Fill(table);\n            GridView2.DataSource = table;\n            GridView2.DataBind();\n            GridView2.Visible = true;\n        }\n    }\n}