function getHeader($type) {\n    switch ($type) {\n        case 'home':\n            return 'Home Header';\n        case 'about':\n            return 'About Header';\n        default:\n            return 'Default Header';\n    }\n}