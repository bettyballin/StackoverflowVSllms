const CleanCSS = require('clean-css');\n   const input = '...'; // Your CSS content\n   const output = new CleanCSS().minify(input);\n\n   console.log(output.styles);