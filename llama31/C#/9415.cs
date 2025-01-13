public class MockHttpRequest : SimpleWorkerRequest\n{\n    private string _Host;\n    private bool _IsSecure;\n\n    public MockHttpRequest(\n        string appVirtualDir, string appPhysicalDir, string page, string query, TextWriter output, string host, bool isSecure) :\n        base(appVirtualDir, appPhysicalDir, page, query, output)\n    {\n        if (string.IsNullOrEmpty(host))\n        {\n            throw new ArgumentException("Host must be provided.");\n        }\n\n        _Host = host;\n        _IsSecure = isSecure;\n    }\n\n    public override bool IsSecureConnection\n    {\n        get { return _IsSecure; }\n    }\n}\n\npublic static class UnitTestingHelper\n{\n    public static HttpContext CreateMockHttpContext(string host, string page, bool isSecure)\n    {\n        string appVirtualDir = "/";\n        string appPhysicalDir = @"C:\Documents and Settings\user\My Documents\Workspace\Project\";\n        string query = string.Empty;\n        TextWriter output = null;\n\n        MockHttpRequest request\n            = new MockHttpRequest(appVirtualDir, appPhysicalDir, "default.aspx", query, output, host, isSecure);\n\n        HttpContext context = new HttpContext(request);\n\n        return context;\n    }\n}