foreach (var path in NetworkPaths)\n{\n    using (var fileStream = File.Open(path, FileMode.Open, FileAccess.ReadWrite, FileShare.None))\n    {\n        // ...\n    }\n}