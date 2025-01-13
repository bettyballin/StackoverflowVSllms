using System.Net;\n\n// Grant permission to listen on port 8080\nProcess process = new Process();\nprocess.StartInfo.FileName = "netsh";\nprocess.StartInfo.Arguments = "http add urlacl url=http://+:8080/ user=DOMAIN\\username";\nprocess.StartInfo.Verb = "runas";\nprocess.Start();\n\n// Create an HttpListener\nvar httpListener = new HttpListener();\n\n// Add the prefix to listen on port 8080\nhttpListener.Prefixes.Add("http://localhost:8080/");\n\n// Start listening\nhttpListener.Start();