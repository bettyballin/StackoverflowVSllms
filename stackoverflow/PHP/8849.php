<?php\nclass AppError extends ErrorHandler {\n  function error404() {\n    $this->controller->beforeFilter();\n    parent::error404();\n  }\n}\n?>