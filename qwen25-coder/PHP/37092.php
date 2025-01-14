<?php\nfunction getBrowser() {\n    $user_agent = $_SERVER['HTTP_USER_AGENT'];\n    \n    if (strpos($user_agent, 'Opera') || strpos($user_agent, 'OPR/')) return 'Opera';\n    elseif (strpos($user_agent, 'Edge')) return 'Edge';\n    elseif (strpos($user_agent, 'Chrome')) return 'Chrome';\n    elseif (strpos($user_agent, 'Safari')) return 'Safari';\n    elseif (strpos($user_agent, 'Firefox')) return 'Firefox';\n    elseif (strpos($user_agent, 'MSIE') || strpos($user_agent, 'Trident/7')) return 'Internet Explorer';\n\n    // Check for mobile devices\n    elseif (strpos($user_agent, 'SonyEricssonK610i')) return 'SonyEricsson K610i';\n    elseif (strpos($user_agent, 'SAMSUNG-SGH-E370')) return 'Samsung SGH E370';\n    elseif (strpos($user_agent, 'SonyEricssonT700')) return 'SonyEricsson T700';\n    elseif (strpos($user_agent, 'NokiaN73-1')) return 'Nokia N73';\n\n    // Add more devices as necessary\n\n    return 'Unknown';\n}\n\necho "You are using: " . getBrowser();\n?>