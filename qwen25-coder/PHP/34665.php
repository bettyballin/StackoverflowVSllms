<?php\n    $content = $post->post_content;\n    preg_match_all('/src=\"(https?:\/\/[\S\w]+)\"/i', $content, $matches, PREG_SET_ORDER);\n    \n    // Check if there are any matches and only process the first one\n    if (!empty($matches)) {\n        $imageUrl = $matches[0][1];  // Get the URL from the first match\n        echo '<img src="http://site/scripts/timthumb.php?src=' . urlencode($imageUrl) . '&h=320&w=214&zc=1" title="" alt="">';\n    }\n?>