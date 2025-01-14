<?php\ndefined('BASEPATH') OR exit('No direct script access allowed');\n\nif (!function_exists('link_to_unless_current')) {\n    function link_to_unless_current($uri, $title, $attributes = []) {\n        $CI =& get_instance();\n        $current_uri = $CI->uri->uri_string();\n        \n        if ($current_uri === trim($uri, '/')) {\n            return $title;\n        } else {\n            return anchor($uri, $title, $attributes);\n        }\n    }\n}\n?>