$arrayObject = new ArrayObject([1, 2, 3, 4, 5]);\n$array = (array) $arrayObject;\n$valueExists = in_array(3, $array);\n\nif ($valueExists) {\n    echo "Value exists in ArrayObject";\n} else {\n    echo "Value does not exist in ArrayObject";\n}