$array = array('test1', 'test2', 'test3', 'test4', 'test5');\n// do a bunch of other stuff, probably a loop\n$array[] = 'test6';\n$lastKey = count($array) - 1;\necho $lastKey; // gives me 5