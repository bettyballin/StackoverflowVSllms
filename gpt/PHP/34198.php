$string = "This is string sample - $2565";\n$split_point = " - ";\n\n$parts = explode($split_point, $string);\n\nprint_r($parts);\n/*\nOutput:\nArray\n(\n    [0] => This is string sample\n    [1] => $2565\n)\n*/