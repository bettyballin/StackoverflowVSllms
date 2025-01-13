<?php\nfunction page_link_by_title($title) {\n    global $wgArticlePath;\n    \n    // Replace spaces with underscores\n    $title = str_replace(' ', '_', $title);\n    \n    // Generate the URL\n    $url = str_replace('$1', $title, $wgArticlePath);\n    \n    return $url;\n}\n\n// Example usage\n$title = "Page_title";\necho '<a href="' . page_link_by_title($title) . '">' . htmlspecialchars($title) . '</a>';\n?>