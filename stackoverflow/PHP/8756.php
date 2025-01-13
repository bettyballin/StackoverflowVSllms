<?php\nfunction gcd($a,$b) {\n    while($a>0 && $b>0) {\n        if($a>$b) $a=$a-$b; else $b=$b-$a;        \n    }\n    if($a==0) return $b;\n    return $a;\n}\nfunction euler5($i=20) {\n    $euler=$x=1;\n    while($x++<$i) {\n        $euler*=$x/gcd($euler,$x);\n    }\n    return $euler;\n}\n\n?>