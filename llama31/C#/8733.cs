using WikiPlex;\n\n// Parse a page\nstring text = "== Heading ==\n\nThis is a paragraph.";\nvar parser = new WikiParser();\nvar doc = parser.Parse(text);\n\n// Get the HTML\nstring html = doc.Render();