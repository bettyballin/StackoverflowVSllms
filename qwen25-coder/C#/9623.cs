// Store only the needed parameters in Session.\n    Session["SearchQuery"] = SetLinqDataSourceWhereAndHisParameters();\n    Guid guid = Guid.NewGuid();\n    Session[guid.ToString()] = "YourCustomKeyForTheSearch"; // Use a custom key or index to refer to your query settings.\n\n    ScriptManager.RegisterStartupScript(this.Page, typeof(Page), "Redirect", \n        String.Format(@"window.open(""{0}"");", \n            this.ResolveClientUrl("~/PageToDisplayTheData.aspx?guid=" + \n                System.Web.HttpUtility.UrlEncode(guid.ToString()) \n        ), true);