HttpCookie myCookie = new HttpCookie("MyCookie");\nmyCookie.Value = "SomeValue";\nmyCookie.Expires = DateTime.Now.AddDays(1);\nResponse.Cookies.Add(myCookie);