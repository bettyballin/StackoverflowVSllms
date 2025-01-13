using System;\nusing System.Collections.Specialized;\nusing System.IO;\nusing System.Net;\nusing System.Text;\n\npublic void ProxyRequest(string url)\n{\n    var form = HttpContext.Current.Request.Form;\n    var postData = new StringBuilder();\n\n    foreach (string key in form.AllKeys)\n    {\n        if (form.GetValues(key) != null)\n        {\n            foreach (var value in form.GetValues(key))\n            {\n                if (postData.Length > 0)\n                    postData.Append("&");\n\n                postData.AppendFormat("{0}={1}", Uri.EscapeDataString(key), Uri.EscapeDataString(value.ToString()));\n            }\n        }\n    }\n\n    using (var client = new WebClient())\n    {\n        var byteArray = Encoding.UTF8.GetBytes(postData.ToString());\n        client.Headers[HttpRequestHeader.ContentType] = "application/x-www-form-urlencoded";\n        client.UploadData(url, "POST", byteArray);\n    }\n}