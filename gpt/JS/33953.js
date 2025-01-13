const minify = require('html-minifier').minify;\n\nconst options = {\n  collapseWhitespace: true,\n  removeComments: true,\n  removeRedundantAttributes: true,\n  removeScriptTypeAttributes: true,\n  removeStyleLinkTypeAttributes: true,\n  useShortDoctype: true\n};\n\nconst html = `<!DOCTYPE html>\n<html>\n<head>\n    <title>Sample Page</title>\n</head>\n<body>\n    <h1>Hello, World!</h1>\n</body>\n</html>`;\n\nconst minifiedHtml = minify(html, options);\nconsole.log(minifiedHtml);