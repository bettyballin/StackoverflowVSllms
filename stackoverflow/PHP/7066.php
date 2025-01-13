<?php\n    function page_title($url) {\n        $fp = file_get_contents($url);\n        if (!$fp) \n            return null;\n\n        $res = preg_match("/<title>(.*)<\/title>/siU", $fp, $title_matches);\n        if (!$res) \n            return null; \n\n        // Clean up title: remove EOL's and excessive whitespace.\n        $title = preg_replace('/\s+/', ' ', $title_matches[1]);\n        $title = trim($title);\n        return $title;\n    }\n?>