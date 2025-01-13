private void SaveButton_Click(object sender, RoutedEventArgs e)\n{\n    try\n    {\n        // End any current edits\n        yourDataGrid.CommitEdit(DataGridEditingUnit.Cell, true);\n        yourDataGrid.CommitEdit(DataGridEditingUnit.Row, true);\n\n        // Update the database with changes\n        dataAdapter.Update(dataTable);\n        MessageBox.Show("Changes saved successfully!");\n    }\n    catch (Exception ex)\n    {\n        MessageBox.Show($"Error saving changes: {ex.Message}");\n    }\n}