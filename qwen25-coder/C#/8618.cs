DataGridViewColumn firstVisibleOrFrozenColumn = null;\nforeach (DataGridViewColumn column in dgv)\n{\n    if ((column.Visible || column.Frozen) && (firstVisibleOrFrozenColumn == null))\n    {\n        firstVisibleOrFrozenColumn = column;\n        break; // Exit once the first match is found\n    }\n}\n\nif (firstVisibleOrFrozenColumn != null)\n{\n    // Do something with the first visible or frozen column\n}\nelse\n{\n    // Handle case where no such column exists\n}