function get_feed() {\n    // Get RSS Feed(s)\n    include_once(ABSPATH . WPINC . '/rss.php');\n    $rss = fetch_rss('http://dorar.shamekh.ws/?feed=rss2');\n    $maxitems = 1;\n\n    // Check if items is an array and has elements\n    if (is_array($rss->items) && count($rss->items) > 0) {\n        $items = array_slice($rss->items, 0, $maxitems, false);\n    } else {\n        $items = []; // Return an empty array if items is not valid\n    }\n\n    return $items;\n}