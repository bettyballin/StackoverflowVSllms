app.UseCookieAuthentication(new CookieAuthenticationOptions\n    {\n        AuthenticationType = DefaultAuthenticationTypes.ApplicationCookie,\n        LoginPath = new PathString("/Account/Login"),\n        CookieSecure = CookieSecureOption.Always,\n    });