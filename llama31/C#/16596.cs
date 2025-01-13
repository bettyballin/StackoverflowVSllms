// Start Fiddler\nvar fiddler = new Fiddler.FiddlerApplication();\n\n// Set up the proxy\nfiddler.Startup(8888, true, true);\n\n// Capture HTTP traffic\nfiddler.BeginInvoke(new Action(() =>\n{\n    var sessions = fiddler.GetSessionList();\n    foreach (var session in sessions)\n    {\n        Console.WriteLine(session.fullUrl);\n    }\n}));