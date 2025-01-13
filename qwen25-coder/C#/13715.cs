protected void Page_Load(object sender, EventArgs e)\n{\n    if (!Page.IsPostBack)\n    {\n        string commandTextFormat = "COUNTRIES.ID, COUNTRIES.NAME, COUNTRIES.POPULATION FROM COUNTRIES";\n        Dictionary<string, string> parameters = new Dictionary<string, string>();\n\n        if (Request.QueryString["NAME"] != null)\n        {\n            commandTextFormat += " WHERE UPPER(COUNTRIES.NAME) LIKE '%' || :NAME || '%'";\n            parameters.Add("NAME", Request.QueryString["NAME"].ToString().ToUpper());\n        }\n\n        // Reset the SelectCommand and SelectParameters\n        this.SqlDataSourceCOUNTRIES.SelectCommand = string.Format("SELECT {0} ORDER BY COUNTRIES.NAME, COUNTRIES.ID", commandTextFormat);\n        this.SqlDataSourceCOUNTRIES.SelectParameters.Clear();\n        foreach (var parameter in parameters)\n        {\n            this.SqlDataSourceCOUNTRIES.SelectParameters.Add(parameter.Key, TypeCode.String, parameter.Value);\n        }\n    }\n\n    // This line ensures that the GridView is refreshed after setting DataSource parameters\n    if (!IsPostBack || SqlDataSourceCOUNTRIES.SelectCommand.Contains("WHERE"))\n    {\n        GridViewCOUNTRIES.DataBind();\n    }\n}