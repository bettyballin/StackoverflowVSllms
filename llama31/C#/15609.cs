// Assume 'dataset' is a private field in your controller or page\nprivate DataSet dataset;\n\nprotected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        // Initialize dataset on first load\n        dataset = GetDataFromDatabase();\n    }\n    else\n    {\n        // Re-populate dataset on postback\n        dataset = GetDataFromDatabase();\n    }\n}\n\nprivate DataSet GetDataFromDatabase()\n{\n    // Implement your database query to retrieve the dataset\n    // ...\n}