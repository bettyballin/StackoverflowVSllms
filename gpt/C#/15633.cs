using System;\nusing System.Text.RegularExpressions;\n\npublic static class HostsFileValidator\n{\n    private static readonly Regex ValidHostnameRegex = new Regex(\n        @"^([a-zA-Z0-9-]{1,63}\.?)+$", \n        RegexOptions.Compiled | RegexOptions.IgnoreCase);\n\n    public static bool IsValidHostsFileDomainName(string domain)\n    {\n        if (string.IsNullOrEmpty(domain) || domain.Length > 255)\n        {\n            return false;\n        }\n\n        if (!ValidHostnameRegex.IsMatch(domain))\n        {\n            return false;\n        }\n\n        // Additional checks for Windows-specific hostnames\n        string[] labels = domain.Split('.');\n        foreach (string label in labels)\n        {\n            if (label.Length == 0 || label.Length > 63)\n            {\n                return false;\n            }\n\n            // Hostname labels should not start or end with a hyphen\n            if (label.StartsWith("-") || label.EndsWith("-"))\n            {\n                return false;\n            }\n        }\n\n        return true;\n    }\n}