// emaillinks.php\n   <?php\n   include 'inc.php';\n\n   // Access the variable from session\n   if (isset($_SESSION['yourVariable'])) {\n       $yourVariable = $_SESSION['yourVariable'];\n       // Use $yourVariable as needed\n   } else {\n       echo "Variable is not set in session.";\n   }\n   ?>