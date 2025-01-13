protected void btnExport_Click(object sender, EventArgs e)\n{\n    Response.Clear();\n    Response.Buffer = true;\n    Response.AddHeader("content-disposition", "attachment;filename=Export.csv");\n    Response.Charset = "";\n    Response.ContentType = "application/text";\n\n    StringBuilder sb = new StringBuilder();\n\n    // Get the header row\n    for (int k = 0; k < GridView1.HeaderRow.Cells.Count; k++)\n    {\n        sb.Append(GridView1.HeaderRow.Cells[k].Text + ',');\n    }\n    sb.Append("\r\n");\n\n    // Get the data rows\n    for (int i = 0; i < GridView1.Rows.Count; i++)\n    {\n        for (int k = 0; k < GridView1.Rows[i].Cells.Count; k++)\n        {\n            sb.Append(GridView1.Rows[i].Cells[k].Text + ',');\n        }\n        sb.Append("\r\n");\n    }\n\n    Response.Output.Write(sb.ToString());\n    Response.Flush();\n    Response.End();\n}