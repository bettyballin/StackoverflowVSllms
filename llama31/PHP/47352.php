$list = new SplDoublyLinkedList();\n$list->push('apple');\n$list->push('banana');\n$list->unshift('orange'); // add an element to the beginning of the list\nprint_r($list); // Output: SplDoublyLinkedList Object ( [flags:SplDoublyLinkedList:private] => 0 [dllist:SplDoublyLinkedList:private] => Array ( [0] => orange [1] => apple [2] => banana ) )