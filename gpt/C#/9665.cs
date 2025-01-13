protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        // Assuming dt is your DataTable and it's already populated with data\n        DataTable dt = GetDataFromDatabase(); // Replace with your data retrieval method\n\n        if (dt.Rows.Count > 0)\n        {\n            bool isActive = dt.Rows[0]["IsActive"].ToString() == "True";\n            chkIsActive.Checked = isActive;\n        }\n    }\n}\n\nprivate DataTable GetDataFromDatabase()\n{\n    // Your logic to get data from the database\n    // Example placeholder code\n    DataTable dt = new DataTable();\n    // Fill your DataTable with data from the database\n    return dt;\n}