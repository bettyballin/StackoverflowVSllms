<?php\n// This loads jQuery 1.x\necho $this->jQuery()->setLocalPath('//ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js')->renderScript();\n\n// This loads jQuery UI 1.7.2\necho $this->jQuery()->uiSetLocalPath('//ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js')->renderUi(true);\n?>