// In your code-behind\nprotected void Page_Load(object sender, EventArgs e)\n{\n    if (Request.Form["hiddenControlData"] != null)\n    {\n        string jsonData = Request.Form["hiddenControlData"];\n        JavaScriptSerializer serializer = new JavaScriptSerializer();\n        Dictionary<string, object>[] controlData = serializer.Deserialize<Dictionary<string, object>[]>(jsonData);\n\n        // Access the control values and attributes\n        foreach (Dictionary<string, object> control in controlData)\n        {\n            string controlId = control["id"].ToString();\n            string controlValue = control["value"].ToString();\n            int controlHeight = int.Parse(control["height"].ToString());\n            // Add other attributes as needed\n        }\n    }\n}