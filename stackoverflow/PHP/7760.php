require 'jsmin-1.1.1.php';\n\n// Output a minified version of example.js.\necho JSMin::minify(file_get_contents('example.js'));