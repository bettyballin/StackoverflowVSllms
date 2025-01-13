<?php\nfunction isMobileSafari() {\n    $userAgent = $_SERVER['HTTP_USER_AGENT'];\n    if (strpos($userAgent, 'Safari') !== false && strpos($userAgent, 'Mobile') !== false) {\n        return true;\n    }\n    return false;\n}\n\nif (isMobileSafari()) {\n    // Serve specific CSS file for Mobile Safari\n    echo '<link rel="stylesheet" type="text/css" href="mobile-safari.css">';\n    \n    // Serve smaller image thumbnails\n    echo '<img src="thumbnail-small.jpg" alt="Thumbnail">';\n} else {\n    // Serve default CSS file\n    echo '<link rel="stylesheet" type="text/css" href="default.css">';\n    \n    // Serve default image thumbnails\n    echo '<img src="thumbnail.jpg" alt="Thumbnail">';\n}\n?>