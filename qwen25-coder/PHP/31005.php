for ($i = 0; $i < 52; $i++) { \n  $j = rand(0, 51);\n\n  // swap the items\n\n  $tmp = $arr[$j];\n  $arr[$j] = $arr[$i];\n  $arr[$i] = $tmp;\n}