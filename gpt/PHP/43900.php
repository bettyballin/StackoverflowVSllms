public function testAction()\n{\n    $city = $this->_getParam('city');\n    $city = urldecode($city);\n    \n    // Now $city should correctly handle URL-encoded characters like Umlauts\n    echo "City: " . htmlspecialchars($city, ENT_QUOTES, 'UTF-8');\n}