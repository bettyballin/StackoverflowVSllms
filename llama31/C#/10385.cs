<%@ Page Language="C#" %>\n\n<script runat="server">\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        string username = Request.Form["username"];\n        string password = Request.Form["password"];\n\n        // Process the form data here...\n    }\n</script>