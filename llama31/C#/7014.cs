public class Column\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n    public bool Visible { get; set; }\n}\n\npublic List<Column> AvailableColumns = new List<Column>\n{\n    new Column { Id = 1, Name = "Column 1", Visible = true },\n    new Column { Id = 2, Name = "Column 2", Visible = true },\n    new Column { Id = 3, Name = "Column 3", Visible = false },\n    // ...\n};