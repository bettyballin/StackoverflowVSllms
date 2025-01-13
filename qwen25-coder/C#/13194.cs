using System;\nusing System.Net;\n\npublic class PathChecker\n{\n    public bool IsLocalPath(string path)\n    {\n        Uri uri = new Uri(path);\n        \n        // Check if it's a UNC path\n        if (uri.IsUnc)\n        {\n            string host = uri.Host;\n            \n            // Get the local machine name and IP addresses\n            string localMachineName = Environment.MachineName.ToLowerInvariant();\n            IPAddress[] localIPs = Dns.GetHostAddresses(Dns.GetHostName());\n\n            // Check against localhost, machine name, or any local IPs\n            return (host == "localhost" || host ==(localMachineName) ||\n                    Array.Exists(localIPs, ip => ip.ToString().Equals(host)));\n        }\n\n        // Non-UNC paths are considered local\n        return true;\n    }\n}