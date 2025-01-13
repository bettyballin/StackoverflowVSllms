public static function getFeed($db)\n{\n    $title = 'Latest feeds';\n    $feedUri = '/rss/';\n    $link = 'http://' . $_SERVER['HTTP_HOST'] . $feedUri;\n    $feedArr = array('title' => $title,\n                     'link'  => $link,\n                     'description' => $title,\n                     'language' => 'en-us',\n                     'charset' => 'utf-8',\n                     'generator' => 'Zend Framework Zend_Feed',\n                     'entries' => array()\n              );\n\n    $itemObjs = array();\n    $select = $db->select('id')->from('things')\n                               ->order('createddate desc')\n                               ->limit(10);\n    $results = $db->fetchAll($select->__toString());\n    $count = count($results);\n    for($i=0;$i<$count;$i++) {\n        $itemObjs[] = SiteUtil::getItemObjectInstance($db, $results[$i]['id']);\n    }\n\n    $count = count($itemObjs);\n    for($i=0;$i<$count;$i++) {\n        $obj = & $itemObjs[$i];\n        $guid = $obj->getId(); // Use a unique identifier for each item\n        $feedArr['entries'][] = array('title' => $obj->getSummary(),\n                                      'link'    => 'http://' . $_SERVER['HTTP_HOST'] . $obj->getDetailUri(),\n                                      'description' => $obj->description,\n                                      'publishdate' => $obj->publishedDate,\n                                      'guid' => $guid\n                                      );\n    }\n\n    $feed = Zend_Feed::importArray($feedArr, 'rss');\n\n    // Handle If-Modified-Since header\n    $ifModifiedSince = $_SERVER['HTTP_IF_MODIFIED_SINCE'];\n    if ($ifModifiedSince) {\n        $modifiedDate = strtotime($ifModifiedSince);\n        $latestItemDate = $feed->getLatestItemDate();\n        if ($latestItemDate <= $modifiedDate) {\n            // Return 304 Not Modified response\n            header('HTTP/1.1 304 Not Modified');\n            exit;\n        }\n    }\n\n    return $feed;\n}