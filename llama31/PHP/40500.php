// Page1.php\n$var = 'Hello, World!';\n\n// Page2.php\ninclude('Page1.php');\necho $var; // Should print "Hello, World!"