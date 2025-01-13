using System;\nusing System.Web;\n\npublic class Global : HttpApplication\n{\n    void Application_BeginRequest(object sender, EventArgs e)\n    {\n        string domain = HttpContext.Current.Request.Url.Host.ToLower();\n        string cssFile = string.Empty;\n\n        switch (domain)\n        {\n            case "domain1.com":\n                cssFile = "css/domain1.css";\n                break;\n            case "domain2.com":\n                cssFile = "css/domain2.css";\n                break;\n            // Add more cases as needed\n            default:\n                cssFile = "css/default.css";\n                break;\n        }\n\n        HttpContext.Current.Items["CssFile"] = cssFile;\n    }\n}