$xml = new SimpleXMLElement(file_get_contents("StopPointList.xml"));\n\n$query = strtolower($_GET["q"]);\n\n$upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";\n$lower = "abcdefghijklmnopqrstuvwxyzæøå";\n\n$result = $xml->xpath("//StopPoint[contains(translate(StopName, '$upper', '$lower'), '$query')]");\n\n// Custom comparison function for sorting\nfunction compareByName($a, $b) {\n    return strcmp((string)$a->StopName, (string)$b->StopName);\n}\n\nusort($result, "compareByName");\n\nforeach ($result as $stop) {\n    echo '<li><a href="stops.php?id=' . htmlspecialchars($stop->DISID) . '">' . "\n";\n    echo "\t" . '<span class="name">' . htmlspecialchars($stop->StopName) . '</span>' . "\n";\n    echo "\t" . '<span class="arrow"></span>' . "\n";\n    echo '</a></li>' . "\n";\n}