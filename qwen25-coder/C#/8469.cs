public void UpdateDatabaseFromDataSet()\n{\n    // Store the currently selected item index\n    int selectedIndex = myDataGrid.SelectedItemIndex;\n\n    try\n    {\n        adapter.Update(exampleDataSet);\n        \n        // Clear and refill the dataset without losing selection context\n        exampleDataSet.Clear();\n        adapter.Fill(exampleDataSet);\n\n        // Restore the previously selected item if possible\n        if (selectedIndex >= 0 && selectedIndex < exampleDataSet.Tables[0].Rows.Count)\n        {\n            myDataGrid.SelectedItemIndex = selectedIndex;\n        }\n    }\n    catch (Exception ex)\n    {\n        MessageBox.Show("An error occurred during database update: " + ex.Message);\n    }\n}