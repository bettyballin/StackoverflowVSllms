function _($key) {\n    static $lang;\n    if ( !$lang ) {\n        $lang = new Lang('Czech'); // Default or find a way to set it\n    }\n    return $lang->_($key);\n}