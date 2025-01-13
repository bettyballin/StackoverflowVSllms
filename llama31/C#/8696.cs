using System;\nusing System.Web;\n\npublic class TabSession\n{\n    private const string TabSessionCookieName = "TabSessionId";\n    private const string TabSessionStorageKey = "TabSessionData";\n\n    public static string GetTabSessionId()\n    {\n        var cookie = HttpContext.Current.Request.Cookies[TabSessionCookieName];\n        if (cookie != null)\n        {\n            return cookie.Value;\n        }\n        return Guid.NewGuid().ToString();\n    }\n\n    public static void SetTabSessionData(string key, string value)\n    {\n        var tabSessionId = GetTabSessionId();\n        var data = new { key, value };\n        HttpContext.Current.Response.Cookies.Add(new HttpCookie(TabSessionCookieName, tabSessionId));\n        HttpContext.Current.Response.Cookies.Add(new HttpCookie(TabSessionStorageKey, Json.Encode(data)));\n    }\n\n    public static string GetTabSessionData(string key)\n    {\n        var tabSessionId = GetTabSessionId();\n        var cookie = HttpContext.Current.Request.Cookies[TabSessionStorageKey];\n        if (cookie != null)\n        {\n            var data = Json.Decode(cookie.Value);\n            if (data.key == key)\n            {\n                return data.value;\n            }\n        }\n        return null;\n    }\n}