<?php\n     require 'vendor/autoload.php';\n     \n     $whoops = new \Whoops\Run;\n     $whoops->pushHandler(new \Whoops\Handler\PrettyPageHandler);\n     $whoops->register();