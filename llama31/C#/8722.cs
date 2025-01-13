public partial class FooRow : IFoo\n{\n    private Bar _bar;\n\n    Bar IFoo.Bar\n    {\n        get { return _bar; }\n    }\n\n    protected override void OnTableChanged(DataTableEventArgs e)\n    {\n        base.OnTableChanged(e);\n\n        if (e.Action == DataTableAction.Add)\n        {\n            this.Table.ColumnChanging += Table_ColumnChanging;\n            this.Table.ColumnChanged += Table_ColumnChanged;\n        }\n    }\n\n    private void Table_ColumnChanging(object sender, DataColumnChangeEventArgs e)\n    {\n        if (e.Column.ColumnName == "BarXml")\n        {\n            // Handle the changing event\n        }\n    }\n\n    private void Table_ColumnChanged(object sender, DataColumnChangeEventArgs e)\n    {\n        if (e.Column.ColumnName == "BarXml")\n        {\n            // Handle the changed event\n            _bar = DeserializeBarXml(e.ProposedValue.ToString());\n        }\n    }\n\n    private Bar DeserializeBarXml(string xml)\n    {\n        // Implement your deserialization logic here\n    }\n}