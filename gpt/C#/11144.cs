protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        if (Session["login"] != null && Session["login"].ToString() == "1")\n        {\n            LoadData();\n        }\n        else\n        {\n            Response.Redirect("login.aspx");\n        }\n    }\n}