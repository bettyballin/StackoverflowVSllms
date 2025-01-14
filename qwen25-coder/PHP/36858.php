$container = new \DI\Container();\n\n   // Registering an entry\n   $container->set('logger', function() {\n       return new Monolog\Logger('my_logger');\n   });\n\n   // Getting the logger instance\n   $logger = $container->get('logger');