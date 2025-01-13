class Logger {\n    static public function log($msg) {\n        $bt = debug_backtrace();\n        array_shift($bt); // skip Logger::log\n        $caller = array_shift($bt); // skip TestClass::__construct\n        echo "$msg (file: {$caller['file']}, line number: {$caller['line']})";\n    }\n}