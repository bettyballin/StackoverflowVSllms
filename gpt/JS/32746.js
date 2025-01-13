// converter.js\n    const showdown  = require('showdown');\n    const fs = require('fs');\n\n    const markdown = fs.readFileSync(0, 'utf-8'); // Read from stdin\n    const converter = new showdown.Converter();\n    const html = converter.makeHtml(markdown);\n\n    console.log(html);