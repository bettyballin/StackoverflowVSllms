$arrayObject = new ArrayObject([1, 2, 3, 4]);\n$valueToCheck = 3;\n\nif (in_array($valueToCheck, $arrayObject->getArrayCopy())) {\n    echo "Value exists in the ArrayObject.";\n} else {\n    echo "Value does not exist in the ArrayObject.";\n}