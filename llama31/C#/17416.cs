// A more recommended approach is to use the built-in ASP.NET security features,\n// such as authentication and authorization, to secure your application.\n[Authorize(Roles = "Admin")]\npublic partial class Page : System.Web.UI.Page\n{\n    // Page code here\n}