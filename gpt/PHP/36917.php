<?php\n$customData = $modx->getObject('modResource', array('id' => 1));\nreturn $customData->get('content');\n?>