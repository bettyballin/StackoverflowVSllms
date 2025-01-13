const purify = require('purify-css');\n\n   const content = ['src/**/*.html', 'src/**/*.js'];\n   const css = ['src/**/*.css'];\n\n   const options = {\n     output: 'dist/purified.css',\n     minify: true,\n     info: true,\n   };\n\n   purify(content, css, options, function (purifiedAndMinifiedResult) {\n     console.log(purifiedAndMinifiedResult);\n   });