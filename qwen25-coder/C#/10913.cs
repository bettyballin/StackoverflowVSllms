using Microsoft.Win32;\nusing System;\n\npublic class DefaultBrowserPathFinder\n{\n    public static string GetDefaultBrowserPath()\n    {\n        // List of methods to fetch the default browser path\n        Func<string>[] methods = new Func<string>[]\n        {\n            GetEdgePath, // For Microsoft Edge (Chromium-based)\n            GetNonEdgeChromeBasedPath, // For other Chromium-based browsers like Chrome\n            GetIEPath, // For Internet Explorer fallback\n            GetMozillaPath // For Mozilla Firefox as an example of non-Chromium browser\n        };\n\n        foreach (var method in methods)\n        {\n            string path = method();\n            if (!string.IsNullOrEmpty(path))\n            {\n                return path;\n            }\n        }\n\n        return "Default browser not found or cannot be determined.";\n    }\n\n    private static string GetEdgePath()\n    {\n        var defaultValue = Registry.GetValue(@"HKEY_CURRENT_USER\Software\Microsoft\Edge\User Data\Profile 1", "browser guid", null);\n        if (defaultValue?.ToString() == "{ee3dbf86-b04d-478e-b92c-ba10fd5ac7c3}") // GUID for Chromium-based Edge\n        {\n            var edgePath = Registry.GetValue(@"HKEY_CLASSES_ROOT\Applications\msedge.exe\shell\open\command", null, null)?.ToString();\n            if (edgePath != null)\n            {\n                return edgePath.Replace("\"%1\"", string.Empty).Trim('"');\n            }\n        }\n\n        return null;\n    }\n\n    private static string GetNonEdgeChromeBasedPath()\n    {\n        var chromeKey = Registry.GetValue(@"HKEY_CURRENT_USER\Software\Google\Chrome\BLBeacon", "versionstable", null);\n        if (chromeKey != null)\n        {\n            var chromeCommandPath = Registry.GetValue(@"HKEY_CLASSES_ROOT\Applications\chrome.exe\shell\open\command", null, null)?.ToString();\n            if (chromeCommandPath != null)\n            {\n                return chromeCommandPath.Replace("\"%1\"", string.Empty).Trim('"');\n            }\n        }\n\n        return null;\n    }\n\n    private static string GetIEPath()\n    {\n        var ieKey = Registry.GetValue(@"HKEY_CURRENT_USER\Software\Microsoft\Windows\Shell\Associations\UrlAssociations\http\userchoice", "ProgId", null)?.ToString();\n        if (ieKey?.StartsWith("IE.HTTP") == true)\n        {\n            return @"C:\Program Files\Internet Explorer\iexplore.exe"; // Default path for IE\n        }\n        return null;\n    }\n\n    private static string GetMozillaPath()\n    {\n        var firefoxKeyPart = Registry.GetValue(@"HKEY_CLASSES_ROOT\FirefoxURL\shell\open\command", "(Default)", null)?.ToString();\n        if (firefoxKeyPart != null && firefoxKeyPart.Contains("firefox.exe"))\n        {\n            return firefoxKeyPart.Replace("\"%1\"", string.Empty).Trim('"');\n        }\n        return null;\n    }\n\n    public static void Main()\n    {\n        Console.WriteLine(GetDefaultBrowserPath());\n    }\n}