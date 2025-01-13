// In your ASPX page\n<form id="myForm" runat="server">\n    <input type="text" id="txtName" name="txtName" />\n    <asp:Button ID="btnSubmit" runat="server" Text="Submit" />\n</form>\n\n// In your code-behind (C#)\nprotected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        Session["txtName"] = "";\n    }\n}\n\nprotected void btnSubmit_Click(object sender, EventArgs e)\n{\n    string name = txtName.Text;\n    Session["txtName"] = name;\n    // Process the data\n}