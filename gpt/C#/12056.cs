[Table(Name = "Company")]\npublic class Company\n{\n    [Column(IsPrimaryKey = true, IsDbGenerated = true, AutoSync = AutoSync.OnInsert)]\n    public long CompanyID { get; set; }\n\n    // Other properties\n    [Column]\n    public string Name { get; set; }\n\n    // Add other properties as needed\n}