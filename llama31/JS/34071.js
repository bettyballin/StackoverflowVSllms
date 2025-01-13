const UglifyJS = require("uglify-js");\n\nconst fs = require("fs");\nconst file = "path/to/your/javascript/file.js";\n\nconst code = fs.readFileSync(file, "utf8");\nconst minifiedCode = UglifyJS.minify(code);\n\nfs.writeFileSync("path/to/minified/file.min.js", minifiedCode.code);