<?php\nfunction isIE6() {\n    return isset($_SERVER['HTTP_USER_AGENT']) && strpos($_SERVER['HTTP_USER_AGENT'], 'MSIE 6.0') !== false;\n}\n\nif (isIE6()) {\n    echo "You are using Internet Explorer 6.";\n} else {\n    echo "You are not using Internet Explorer 6.";\n}\n?>