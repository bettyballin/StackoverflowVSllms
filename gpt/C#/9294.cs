protected void CheckBoxList1_ItemDataBound(object sender, ListItemEventArgs e)\n{\n    // Example: Apply different styles based on the item value or index\n    if (e.Item.Value == "specificValue")\n    {\n        e.Item.Attributes.CssStyle.Add("color", "red");\n        e.Item.Attributes.CssStyle.Add("font-weight", "bold");\n    }\n    else\n    {\n        e.Item.Attributes.CssStyle.Add("color", "blue");\n    }\n}