// assumes: using System.DirectoryServices.AccountManagement;\npublic override bool ValidateUser( string username, string password )\n{\n  bool result = false;\n\n  try\n  {\n    using( var context = \n        new PrincipalContext( ContextType.Domain, "yourDomainName" ) )\n    {\n      result = context.ValidateCredentials( username, password );\n    }\n  }\n  catch( Exception ex )\n  {\n    // TODO: log exception\n  }\n\n  return result;\n}