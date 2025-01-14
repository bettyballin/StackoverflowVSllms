<?php\n\n   require_once('vendor/autoload.php');\n\n   ob_start(); // Start output buffering\n\n   $firephp = \FirePHP::getInstance(true);\n\n   $firephp->log('Log Message');\n   $firephp->group('Test Group');\n   $firephp->log("Some Message", "Label");\n   $firephp->log(array(1,2,"apple"), 'Array Log');\n   $firephp->warn('Warning...');\n   $firephp->error('Error...');\n   $firephp->groupEnd();\n\n   ?>