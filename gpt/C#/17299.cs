public class MyDataModel\n{\n    public string Name { get; set; }\n    public bool IsVisible { get; set; }\n}\n\n// Assuming 'bindingList' is your BindingList<MyDataModel>\nbindingList[0].IsVisible = false;\n\n// Event handler to apply visibility changes\ndataGridView.RowPrePaint += (sender, e) =>\n{\n    if (e.RowIndex >= 0)\n    {\n        var row = dataGridView.Rows[e.RowIndex];\n        var data = row.DataBoundItem as MyDataModel;\n        if (data != null)\n        {\n            row.Visible = data.IsVisible;\n        }\n    }\n};\n\n// Set your DataGridView's data source\ndataGridView.DataSource = bindingList;