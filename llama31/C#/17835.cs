protected void Page_Load(object sender, EventArgs e)\n{\n    if (Request.HttpMethod != "POST")\n    {\n        Response.Redirect("ListInstructors.aspx");\n    }\n}