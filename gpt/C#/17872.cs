public class MyObject\n{\n    public string Title { get; set; }\n    public string Author { get; set; }\n    public string Category { get; set; }\n}\n\n// Assuming you have a list of objects\nList<MyObject> ListFiles = new List<MyObject>\n{\n    new MyObject { Title = "Title1", Author = "Author1", Category = "Category1" },\n    new MyObject { Title = "Title2", Author = "Author2", Category = "Category2" }\n    // Add more items here\n};\n\nList<MyObject> ListContaining = new List<MyObject>(ListFiles);\n\nprivate void InitializeComboBoxes()\n{\n    Title_Combo.DataSource = ListContaining.Select(item => item.Title).Distinct().ToList();\n    Author_Combo.DataSource = ListContaining.Select(item => item.Author).Distinct().ToList();\n    Category_Combo.DataSource = ListContaining.Select(item => item.Category).Distinct().ToList();\n}\n\nprivate void Title_Combo_SelectedIndexChanged(object sender, EventArgs e)\n{\n    UpdateListContaining("Title", Title_Combo.SelectedItem.ToString());\n}\n\nprivate void Author_Combo_SelectedIndexChanged(object sender, EventArgs e)\n{\n    UpdateListContaining("Author", Author_Combo.SelectedItem.ToString());\n}\n\nprivate void Category_Combo_SelectedIndexChanged(object sender, EventArgs e)\n{\n    UpdateListContaining("Category", Category_Combo.SelectedItem.ToString());\n}\n\nprivate void UpdateListContaining(string propertyName, string selectedValue)\n{\n    ListContaining = ListFiles.Where(item => item.GetType().GetProperty(propertyName).GetValue(item, null).ToString() == selectedValue).ToList();\n    InitializeComboBoxes();\n}\n\n// Call this method in your form load or initialization\nprivate void Form1_Load(object sender, EventArgs e)\n{\n    InitializeComboBoxes();\n    Title_Combo.SelectedIndexChanged += Title_Combo_SelectedIndexChanged;\n    Author_Combo.SelectedIndexChanged += Author_Combo_SelectedIndexChanged;\n    Category_Combo.SelectedIndexChanged += Category_Combo_SelectedIndexChanged;\n}