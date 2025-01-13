protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        string guid = System.Web.HttpUtility.UrlDecode(Request.QueryString["guid"]);\n        if (!string.IsNullOrEmpty(guid))\n        {\n            // Retrieve and set the Where clause and parameters\n            myLinqDS.Where = (string)Session[guid + "_Where"];\n            myLinqDS.WhereParameters.Clear();\n            foreach (Parameter param in (ParameterCollection)Session[guid + "_WhereParameters"])\n            {\n                myLinqDS.WhereParameters.Add(param);\n            }\n\n            // Bind the data\n            aDataList.DataSource = myLinqDS;\n            aDataList.DataBind();\n        }\n    }\n}