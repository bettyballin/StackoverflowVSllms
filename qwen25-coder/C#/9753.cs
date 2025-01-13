public ActionResult AcceptPendingUser(int userId)\n{\n    // Fetch the member by id and process acceptance logic (e.g., update database status)\n    var user = GetMemberById(userId);\n    if (user != null)\n    {\n        // Logic to accept user, e.g., change status and send welcome email\n    }\n    \n    return RedirectToAction("Index");\n}\n\npublic ActionResult RejectPendingUser(int userId)\n{\n    // Fetch the member by id and process rejection logic (e.g., remove from pending list)\n    var user = GetMemberById(userId);\n    if (user != null)\n    {\n        // Logic to reject user, e.g., change status and send rejection email\n    }\n\n    return RedirectToAction("Index");\n}