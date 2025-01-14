var htmlString = "<h2>{title}</h2>\n<p><a href=\"{url}\">{content}</a></p>";\nvar pattern = /\{([a-zA-Z]+)\}/g;\nvar matches = htmlString.match(pattern).map(function(val) {\n  return val.replace(/[{}]/g, '');\n});\n\nconsole.log(matches); // Output: ['title', 'url', 'content']