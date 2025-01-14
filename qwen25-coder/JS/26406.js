const nonInternetEmailRegex = /^[a-zA-Z0-9._%+-]+@(?!gmail\.com|yahoo\.(?:com|co\.id|in)|hotmail\.com|outlook\.com)[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;\n\nfunction isValidNonInternetEmail(email) {\n    return nonInternetEmailRegex.test(email);\n}\n\n// Example usage\nconsole.log(isValidNonInternetEmail("user@mycompany.com")); // true\nconsole.log(isValidNonInternetEmail("user@gmail.com"));     // false