string cookieContent = "your cookie content";\nstring encryptedContent = FormsAuthentication.Encrypt(new FormsAuthenticationTicket(cookieContent, false, 30));\n\n// Set the encrypted cookie\nHttpCookie cookie = new HttpCookie("YourCookieName", encryptedContent);\nResponse.Cookies.Add(cookie);