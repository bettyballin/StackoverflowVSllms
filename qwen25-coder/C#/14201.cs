using (var client = new HttpClient())\n    {\n        var content = new StringContent(txtMsg.Text, Encoding.UTF8, "text/xml");\n        HttpResponseMessage response = await client.PostAsync(cboUrl.Text, content);\n        string result = await response.Content.ReadAsStringAsync();\n        // Handle the response here\n    }