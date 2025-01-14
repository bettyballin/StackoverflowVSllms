require_once 'Zend/Loader.php';\nZend_Loader::loadClass('Zend_Gdata_YouTube');\n\n$yt = new Zend_Gdata_YouTube();\n$query = $yt->newVideoQuery();\n\n// Ensure the search term is URL-encoded and valid\n$searchTerm = urlencode($this->data['ItemVideo']['q']);\n\n$query->setOrderBy($this->data['ItemVideo']['sort']);\n$query->setRacy('include');\n$query->setQuery($searchTerm); // Assuming you are searching for videos rather than setting a category\n\n// Set the default URI if it is not auto-set\nif (!$query->_defaultFeedUri) {\n    $query->setDefaultFeedUri('http://gdata.youtube.com/feeds/api/videos');\n}\n\ntry {\n    $videoFeed = $yt->getVideoFeed($query);\n} catch(Exception $e) {\n    echo var_dump($query) . '<p></p>' . $e;\n}