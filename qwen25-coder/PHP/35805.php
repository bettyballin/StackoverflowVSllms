// web/backend/index.php\n<?php\n\nrequire_once('/path/to/your/symfony/data/global/vendor/autoload/sfCoreAutoloadRegister.class.php');\nsfCoreAutoloadRegister::register();\n\n$configuration = ProjectConfiguration::getApplicationConfiguration('backend', 'prod', false);\n(sfContext::createInstance($configuration))->dispatch();