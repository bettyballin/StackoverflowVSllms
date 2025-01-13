using System;\nusing System.Web.Services;\n\n[WebService(Namespace = "http://example.com/")]\npublic class MyService : WebService\n{\n    [WebMethod]\n    public string GetData()\n    {\n        // Check if the request method is GET\n        EnsureRequestIs("GET");\n\n        // Your logic to return data\n        return "Data";\n    }\n\n    [WebMethod]\n    public void SubmitData(string data)\n    {\n        // Check if the request method is POST\n        EnsureRequestIs("POST");\n\n        // Your logic to process and save data\n    }\n\n    private void EnsureRequestIs(string expectedVerb)\n    {\n        string actualVerb = HttpContext.Current.Request.HttpMethod;\n        if (!string.Equals(actualVerb, expectedVerb, StringComparison.OrdinalIgnoreCase))\n        {\n            throw new InvalidOperationException($"This method only accepts HTTP {expectedVerb} requests.");\n        }\n    }\n}