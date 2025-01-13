// Assume you have a method in your Data Access Layer like this:\npublic class DataAccessLayer\n{\n    public DataTable GetData()\n    {\n        // Return a DataTable with the data you need for the report\n    }\n}\n\n// In your code-behind, create an instance of the ObjectDataSource and bind it to your method\nprotected void Page_Load(object sender, EventArgs e)\n{\n    ObjectDataSource ods = new ObjectDataSource();\n    ods.TypeName = typeof(DataAccessLayer).AssemblyQualifiedName;\n    ods.SelectMethod = "GetData";\n    ods.ID = "odsMyData";\n\n    // Add the ObjectDataSource to the page\n    Page.Controls.Add(ods);\n\n    // Now you can use the ObjectDataSource with your report\n    ReportViewer1.LocalReport.DataSources.Add(new ReportDataSource("MyData", ods));\n}