using System;\n\npublic class HelloWorld : System.Web.UI.Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        Response.Write("Hello, World!");\n    }\n}