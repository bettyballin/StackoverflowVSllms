OpenIdRelyingParty openid = new OpenIdRelyingParty();\nIAuthenticationRequest req = openid.CreateRequest(openid_identifier.Text);\n\nClaimsRequest fetch = new ClaimsRequest();\nfetch.Email = DemandLevel.Require;\nfetch.Nickname = DemandLevel.Require;\nreq.AddExtension(fetch);\n\nreq.RedirectToProvider();