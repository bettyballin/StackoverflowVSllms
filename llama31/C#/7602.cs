private void DataGridView_RowStateChanged(object sender, DataGridViewRowStateChangedEventArgs e)\n{\n    if (e.StateChanged == DataGridViewElementStates.Visible)\n    {\n        if (e.Row.Index == 0)\n        {\n            e.Row.Visible = false;\n        }\n    }\n}