const cheerio = require('cheerio');\n\nconst $ = cheerio.load('<html><body></body></html>');\n// execute your JavaScript code to generate HTML\n$.root().append('<div>Generated HTML</div>');\nconst html = $.html();\nconsole.log(html); // rendered HTML source