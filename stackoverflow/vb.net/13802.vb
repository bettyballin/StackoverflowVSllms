MostRecentIDs as String() '' // Instance level variables\nConst ListSize = 5\n\n'' // in a method somewhere\ncontext As HttpContext = HttpContext.Current\ncookie As HttpCookie = context.Request.Cookies("mri")\nmri As Queue(Of String)\n\nIf cookie Is Nothing Then\n    mri = New Queue(Of String)(cookie.Value.Split(",".ToCharArray())\nElse\n    mri = New Queue(Of String)\n    cookie = New HttpCookie("mri")\nEnd If\n\nIf mri.Contains(Request.QueryString("id")) Then\n\n    If mri.Count >= ListSize Then mri.Dequeue()\n\n    mri.Enqueue(Request.QueryString("id"))\n\nEnd If\n\nMostRecentIDs = mri.ToArray();\n\ncookie.Value = String.Join(",", MostRecentIDs)\ncookie.Expires = DateTime.Now.AddDays(365)\n\ncontext.Response.Add(cookie)