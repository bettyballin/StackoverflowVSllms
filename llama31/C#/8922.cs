// Create a new TableAdapter\ncpcDSTableAdapters.tbl_cpcTableAdapter adapter = new cpcDSTableAdapters.tbl_cpcTableAdapter();\n\n// Modify the SelectCommand to include a parameterized query\nadapter.SelectCommand.CommandText = "SELECT * FROM tbl_cpc WHERE cpcID = @cpcID";\nadapter.SelectCommand.Parameters.AddWithValue("@cpcID", cpcID);\n\n// Fill the dataset with the filtered results\ncpcDS.tbl_cpcDataTable table = adapter.GetData();