$obj = new User();\n$obj->setfname('John');\n$obj->setage(32);\n\n$jsonString = json_encode($obj);\necho $jsonString; // Output: {"fname":"John","age":32}