protected void Repeater1_ItemDataBound(object sender, RepeaterItemEventArgs e)\n{\n    try\n    {\n        // Your data binding code here\n    }\n    catch (Exception ex)\n    {\n        e.Item.Visible = false;\n        // You can also log the exception here\n    }\n}