function riskyFunction(userInput):\n    // Bug: This code does not validate userInput and expects a specific type.\n    if userInput == "admin":\n        grantAdminPrivileges()\n    else:\n        denyAccess()\n\n// Vulnerability Example:\nfunction vulnerableLogin(username, password):\n    // Vulnerability: Hardcoded credentials can be exploited\n    if username == "default" and password == "password123":\n        authenticateUser()