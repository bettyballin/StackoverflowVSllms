using (PrincipalContext ctx = new PrincipalContext(ContextType.Domain, domain))\n{\n    UserPrincipal user = UserPrincipal.FindByIdentity(ctx, username);\n    if (user != null)\n    {\n        string fullName = user.DisplayName;\n        string emailAddress = user.EmailAddress;\n        \n        // Additional properties can be accessed here\n        // Example: string telephone = user.VoiceTelephoneNumber;\n\n        // Output the details\n        Console.WriteLine($"Full Name: {fullName}");\n        Console.WriteLine($"Email Address: {emailAddress}");\n    }\n    else\n    {\n        // Handle case where user is not found\n        Console.WriteLine("User not found in Active Directory.");\n    }\n}