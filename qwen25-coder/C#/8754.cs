// Assuming 'row' is a DataGridViewRow instance from your DataGridView\n\nvar locationColumn = dataGridView.Columns["Location"] as DataGridViewComboBoxColumn;\nBindingSource bindingSource = (BindingSource)locationColumn.DataSource;\n\nCustomObject selectedObject = null;\nforeach (CustomObject item in bindingSource.List)\n{\n    if (item.ID.Equals(row.Cells["Location"].Value))\n    {\n        selectedObject = item;\n        break;\n    }\n}\n\nif (selectedObject != null)\n{\n    // Now you have a reference to the actual object\n}