private void checkedListBox1_ItemCheck(object sender, ItemCheckEventArgs e)\n{\n    if (/* condition to check if item is uncheckable */)\n    {\n        e.NewValue = CheckState.Unchecked;\n    }\n}