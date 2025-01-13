using System;\nusing System.IO;\nusing System.Reflection;\n\npublic static void RegisterTlbFromEmbeddedResource()\n{\n    var assembly = Assembly.GetExecutingAssembly();\n    string[] resourceNames = assembly.GetManifestResourceNames();\n\n    foreach (string resourceName in resourceNames)\n    {\n        if (resourceName.EndsWith(".tlb", StringComparison.OrdinalIgnoreCase))\n        {\n            using (Stream stream = assembly.GetManifestResourceStream(resourceName))\n            {\n                if (stream == null) continue;\n\n                byte[] buffer = new byte[stream.Length];\n                stream.Read(buffer, 0, buffer.Length);\n\n                string tempFilePath = Path.Combine(Path.GetTempPath(), "yourresource.tlb");\n                File.WriteAllBytes(tempFilePath, buffer);\n\n                // Register the .tlb file if necessary\n                // For registry-free COM, place .manifest files correctly instead of registering\n                Console.WriteLine("Extracted to: " + tempFilePath);\n            }\n        }\n    }\n}