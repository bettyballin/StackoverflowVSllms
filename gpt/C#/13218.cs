using System;\nusing System.Web;\nusing ComponentSpace.SAML2;\n\npublic partial class SSO : System.Web.UI.Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        if (!IsPostBack)\n        {\n            string partnerIdP = "http://idp-domain.com";\n            SAMLServiceProvider.InitiateSSO(Response, null, partnerIdP);\n        }\n    }\n}\n\npublic partial class ACS : System.Web.UI.Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        if (!IsPostBack)\n        {\n            string partnerIdP = null;\n            string authnContext;\n            string userName;\n            string relayState;\n            SAMLServiceProvider.ReceiveSSO(Request, out partnerIdP, out authnContext, out userName, out relayState);\n\n            // User is successfully authenticated\n            // Implement your logic here, for example:\n            Session["UserName"] = userName;\n            Response.Redirect("~/Home.aspx");\n        }\n    }\n}