<%@ Page Language="C#" %>\n<!DOCTYPE html>\n<html>\n<head>\n    <title>404 - Page Not Found</title>\n</head>\n<body>\n    <h1>Page Not Found</h1>\n    <p>The page you requested could not be found. You tried to access:</p>\n    <p><strong><%= Server.HtmlEncode(Request.RawUrl) %></strong></p>\n    <p>We will try to redirect you to the correct page.</p>\n    \n    <script type="text/javascript">\n        // JavaScript redirection logic can be added here if necessary\n    </script>\n</body>\n</html>