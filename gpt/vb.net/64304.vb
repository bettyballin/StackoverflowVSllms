' Create and set a cookie\n   Dim cookie As New HttpCookie("UserName")\n   cookie.Value = "JohnDoe"\n   cookie.Expires = DateTime.Now.AddHours(1)\n   Response.Cookies.Add(cookie)\n\n   ' Retrieve value from cookie\n   Dim userName As String = Request.Cookies("UserName").Value