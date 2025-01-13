using System;\nusing System.Web.Services;\n\n[WebService(Namespace = "http://tempuri.org/")]\n[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]\n[System.ComponentModel.ToolboxItem(false)]\n// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line.\n[System.Web.Script.Services.ScriptService]\npublic class Logout : System.Web.UI.Page\n{\n    [WebMethod]\n    public static string EndSession()\n    {\n        try\n        {\n            HttpContext.Current.Session.Clear();\n            HttpContext.Current.Session.Abandon();\n\n            // Clear session cookies from browser\n            var cookie1 = new HttpCookie("ASP.NET_SessionId", "")\n            {\n                Expires = DateTime.Now.AddYears(-50)\n            };\n            HttpContext.Current.Response.Cookies.Add(cookie1);\n\n            return "success";\n        }\n        catch (Exception ex)\n        {\n            // Log the exception details instead of returning error messages to client.\n            return "error"; // Return a generic error message\n        }\n    }\n}