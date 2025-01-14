public static function loadConfig($file, $type)\n{\n    // Assuming the Asra_Core_Exception class is autoloaded\n    if (!file_exists($file)) {\n        throw new Asra_Core_Exception("{$type} file was not present at specified location: {$file}");\n    }\n\n    // Use @ to suppress warnings and convert them into exceptions\n    $parse = @parse_ini_file($file, true);\n    if ($parse === false) {\n        throw new Asra_Core_Exception("{$type} file at {$file} could not be parsed or is invalid.");\n    }\n    \n    return $parse;\n}