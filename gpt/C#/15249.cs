using Microsoft.Security.Application;\n\npublic ActionResult SaveContent(string content)\n{\n    // Sanitize the content to prevent XSS attacks\n    string sanitizedContent = Sanitizer.GetSafeHtmlFragment(content);\n\n    // Save the sanitized content to the database or perform other actions.\n    // ...\n\n    return RedirectToAction("Index");\n}