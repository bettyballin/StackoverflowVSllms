@model IEnumerable<YourNamespace.Models.YourModel>\n@(Html.Grid(Model).Columns(column =>\n{\n    column.For(x => x.Property1);\n    // other columns...\n}))