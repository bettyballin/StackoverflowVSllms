<?php\n   require 'vendor/autoload.php';\n\n   use League\Plates\Engine;\n\n   // Create new Plates instance\n   $templates = new Engine('/path/to/templates');\n\n   // Render a template\n   echo $templates->render('home');