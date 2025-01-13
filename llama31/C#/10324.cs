// Example of potential issues with different IIS versions\nusing System.Web;\n\nclass IISVersionExample\n{\n    public void TestIISVersion()\n    {\n        // IIS6\n        string iis6Path = HttpContext.Current.Request.ServerVariables["APPL_PHYSICAL_PATH"];\n        \n        // IIS7\n        string iis7Path = HttpContext.Current.Server.MapPath("~");\n\n        // Potential issue: iis6Path and iis7Path might not match\n    }\n}