echo '<a href="#" onclick="updateByQuery(\'Layer3\', \'' . str_replace('\"', "'", json_encode($query, JSON_UNESCAPED_SLASHES | JSON_HEX_TAG)) . '\');">Link 1</a>';