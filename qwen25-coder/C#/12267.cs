using Ganss.XSS;\n\npublic string SanitizeHtml(string input)\n{\n    var sanitizer = new HtmlSanitizer();\n    return sanitizer.Sanitize(input);\n}\n\nstring userInput = "<div><b>Hello</b> <script>alert('XSS');</script></div>";\nstring sanitizedInput = SanitizeHtml(userInput); // Will remove the script tag\n\n// Now store sanitizedInput in your database