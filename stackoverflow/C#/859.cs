void MyOuterRepeater_ItemDataBound(Object sender, RepeaterItemEventArgs e) \n    {\n    // Find the Inner DataSource control in this Row.\n    SqlDataSource s = (SqlDataSource)e.Item.FindControl("InnerDataSource");\n\n    // Set the SelectParameter for this DataSource control\n    // by re-evaluating the field that is to be passed.\n    s.SelectParameters["MyParam"].DefaultValue = DataBinder.Eval(e.Item.DataItem, "MyFieldValueToPass").ToString();\n    }