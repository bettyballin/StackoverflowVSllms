Session.Clear();\nSession.Abandon();\n// Delete the session cookie\nResponse.Cookies["ASP.NET_SessionId"].Expires = DateTime.Now.AddDays(-1);