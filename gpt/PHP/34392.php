function handleUndefinedVariable($errno, $errstr, $errfile, $errline) {\n    if (error_reporting() === 0) {\n        // Error reporting is currently turned off or suppressed with @ operator\n        return false;\n    }\n    if ($errno === E_NOTICE && preg_match('/^Undefined variable:/', $errstr)) {\n        throw new ErrorException($errstr, 0, $errno, $errfile, $errline);\n    }\n    return false; // let the default error handler run\n}\n\nset_error_handler('handleUndefinedVariable');\nerror_reporting(E_ALL);\n\npublic function testSomething()\n{\n    $entity_id = 1; // Define your variable\n    $name = perform_sql_query("SELECT name FROM table WHERE id = $entity_id;");\n    assert($name == "some_name");\n}