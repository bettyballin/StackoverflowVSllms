$array = array('test1', 'test2', 'test3', 'test4', 'test5');\n// do a bunch of other stuff, probably a loop\n$lastKey = count($array); // Since PHP arrays are 0-indexed, this gives the next key\n$array[] = 'test6';\necho $lastKey; // gives you the key of the last added element, in this case 5