$ids = array(1, 2, 3);\n$names = array("cat", "elephant", "cow");\n$originalSettings = array('ids' => $ids, 'names' => $names);\n$jsonSettings = json_encode($originalSettings, JSON_HEX_TAG | JSON_HEX_AMP | JSON_HEX_APOS | JSON_HEX_QUOT);\necho $jsonSettings;