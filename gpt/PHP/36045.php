// config.php\ndefine('BASE_URL', getenv('BASE_URL') ?: '/');\n\n// functions.php\nfunction gen_link($path) {\n    return BASE_URL . $path;\n}\n\n// In your views\n<a href="<?php echo gen_link('/'); ?>">Home</a>\n<a href="<?php echo gen_link('/some/thing'); ?>">Some Page</a>