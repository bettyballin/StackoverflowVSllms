private void flowLayoutPanel1_ControlAdded(object sender, ControlEventArgs e)\n{\n    SortControlsByDate();\n}\n\nprivate void SortControlsByDate()\n{\n    // Get all controls in the FlowLayoutPanel that have the date property\n    var controls = flowLayoutPanel1.Controls.Cast<Control>()\n        .Where(ctrl => ctrl is YourCustomControlType)\n        .OrderBy(ctrl => ((YourCustomControlType)ctrl).DateProperty)\n        .ToArray();\n\n    // Update the index of each control to match the sorted order\n    for (int i = 0; i < controls.Length; i++)\n    {\n        flowLayoutPanel1.SetChildIndex(controls[i], i);\n    }\n}