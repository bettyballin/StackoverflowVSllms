// Page A: Redirect to Page B with OrderId\n   protected void DataGrid_ItemCommand(object source, DataGridCommandEventArgs e)\n   {\n       if (e.CommandName == "SelectOrder")\n       {\n           string orderId = e.CommandArgument.ToString();\n           Response.Redirect("PageB.aspx?OrderId=" + orderId);\n       }\n   }