if (openid.Response != null)\n{\n    ClaimsResponse fetch = openid.Response.GetExtension(typeof(ClaimsResponse)) as ClaimsResponse;\n    if (fetch != null)\n    {\n        string nick = fetch.Nickname;\n        string email = fetch.Email;\n        // ...\n    }\n}