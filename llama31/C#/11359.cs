void Session_Start(object sender, EventArgs e)\n{\n    // Log session start\n    using (var writer = new StreamWriter("session_log.txt", true))\n    {\n        writer.WriteLine($"Session started: {Session.SessionID}");\n    }\n}\n\nvoid Session_End(object sender, EventArgs e)\n{\n    // Log session end\n    using (var writer = new StreamWriter("session_log.txt", true))\n    {\n        writer.WriteLine($"Session ended: {Session.SessionID}");\n    }\n}