<%\nDim sessionIdFromUrl\n\n' Retrieve session id from URL query string\nsessionIdFromUrl = Request.QueryString("sessionid")\n\nIf Not IsEmpty(sessionIdFromUrl) Then\n    ' Re-establish the same session by setting it explicitly (warning: requires server-side handling)\n    Session.SessionID = sessionIdFromUrl\nEnd If\n\n' Continue with your checkout process...\n%>