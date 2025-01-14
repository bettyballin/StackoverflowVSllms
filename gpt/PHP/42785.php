<?php\nfunction getMarkup($condition) {\n    if ($condition) {\n        return '<div>[SOME MARKUP]</div>';\n    } else {\n        return '<div>[OTHER MARKUP]</div>';\n    }\n}\n\n$a = true; // Example condition, this can be any boolean expression\n?>\n\n<!DOCTYPE html>\n<html lang="en">\n<head>\n    <meta charset="UTF-8">\n    <title>Document</title>\n</head>\n<body>\n    <?php echo htmlspecialchars(getMarkup($a), ENT_QUOTES, 'UTF-8'); ?>\n</body>\n</html>