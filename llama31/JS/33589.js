const wikitext = require('wikitext');\n\n// Parse a page\nconst text = '== Heading ==\n\nThis is a paragraph.';\nconst parser = new wikitext.Parser();\nconst doc = parser.parse(text);\n\n// Get the HTML\nconst html = doc.render();