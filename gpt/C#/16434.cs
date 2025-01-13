// Assuming you have a UserProfile class and a method to get the profile from the database\npublic class UserProfile\n{\n    public string Username { get; set; }\n    public string Email { get; set; }\n    // Other properties\n}\n\npublic UserProfile GetUserProfileFromDb(string username)\n{\n    // Retrieve the user profile from the database\n    // This is just a placeholder for the actual database access code\n    return new UserProfile { Username = username, Email = "user@example.com" };\n}\n\npublic UserProfile GetUserProfile(string username)\n{\n    // Check if the user profile is already cached\n    UserProfile profile = HttpContext.Current.Cache[username] as UserProfile;\n    if (profile == null)\n    {\n        // Not in cache, load from database\n        profile = GetUserProfileFromDb(username);\n        \n        // Cache the user profile for future requests\n        HttpContext.Current.Cache.Insert(\n            username, \n            profile, \n            null, \n            DateTime.UtcNow.AddMinutes(10), // Cache duration\n            System.Web.Caching.Cache.NoSlidingExpiration\n        );\n    }\n    return profile;\n}