function parse_links($text) {\n    $url_pattern = '/(https?:\/\/[^\s]+)/';\n    $email_pattern = '/\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}\b/';\n\n    $text = preg_replace_callback($url_pattern, function($match) {\n        $url = $match[0];\n        if (!preg_match('/^https?:\/\//', $url)) {\n            $url = 'http://' . $url;\n        }\n        return '<a href="' . $url . '">' . $match[0] . '</a>';\n    }, $text);\n\n    $text = preg_replace_callback($email_pattern, function($match) {\n        $email = $match[0];\n        return '<a href="mailto:' . $email . '">' . $email . '</a>';\n    }, $text);\n\n    return $text;\n}