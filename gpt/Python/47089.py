#!/usr/bin/env python3\nimport cgi\n\nprint("Content-Type: text/html")\nprint()\n\nform = cgi.FieldStorage()\njs_variable = form.getvalue("jsVariable")\n\nprint(f"<html><body>")\nprint(f"<p>Received JavaScript variable: {js_variable}</p>")\nprint(f"</body></html>")