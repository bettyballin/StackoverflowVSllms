protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        // Assuming GetData() fetches data from your database\n        DataTable dt = GetData();\n        DataList1.DataSource = dt;\n        DataList1.DataBind();\n    }\n}\n\nprivate DataTable GetData()\n{\n    // Your database fetching logic here\n    // Return a DataTable with the HTML content in a column (e.g., "YourHtmlField")\n}