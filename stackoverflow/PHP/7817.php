$obj = new OBJ();\n\ngo('http://www.mysite.com/hello', $obj);\n\nfunction go( $url, $object )\n{\n    $array = $object->grabArray($url);\n    echo $array['hits'];\n}