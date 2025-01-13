public int FindInBindingSource(BindingSource bindingSource, string column1, object value1, string column2, object value2)\n{\n    // Cast the BindingSource to an IList for iteration\n    IList list = bindingSource.List;\n\n    for (int i = 0; i < list.Count; i++)\n    {\n        DataRowView rowView = list[i] as DataRowView;\n        if (rowView != null)\n        {\n            if (rowView[column1].Equals(value1) && rowView[column2].Equals(value2))\n            {\n                return i; // Return the index if both values match\n            }\n        }\n    }\n\n    return -1; // Return -1 if no match is found\n}\n\n// Usage example\nint index = FindInBindingSource(bindingSource, "Column1Name", comboBox.SelectedValue, "Column2Name", treeView.SelectedNode.Tag);\nif (index != -1)\n{\n    bindingSource.Position = index; // Set the position of the BindingSource\n}\nelse\n{\n    // Handle case where no match is found\n}