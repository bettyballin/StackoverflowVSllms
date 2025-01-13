var employees = from e in db.Employees\n                select new { \n                    ID = e.ID, \n                    FullName = e.Lastname + ", " + e.Firstname \n                };\n\nListBox1.DataSource = employees;\nListBox1.DataTextField = "FullName";\nListBox1.DataValueField = "ID";\nListBox1.DataBind();