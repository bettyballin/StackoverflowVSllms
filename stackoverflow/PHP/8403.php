$dataCallback = array(\n    array($othObj, 'getData'),\n    array($othObj, 'getThisData'),\n    array($anothObj, 'getTheData'),\n    array($anothOne, 'getAData'),\n);\n\nfor($i = 0, $t = count($dataCallback); !isset($data) && $i < $t; $i++) {\n  $callback = $dataCallback[$i];\n  $data = call_user_func($callback);\n}\n\nif (isset($data))\n  process($data);\nelse\n  //no valid data returned at all ...