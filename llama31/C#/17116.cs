using (PrincipalContext context = new PrincipalContext(ContextType.Domain, domain, "LDAPS://" + domain + ":636"))