<?php\n$x = $y = 100;\n$gd = imagecreatetruecolor($x,$y);\n$w  = imagecolorallocate($gd, 255, 255, 255);\n$b  = imagecolorallocate($gd, 0, 0, 0);\n\nfor ($r=1; $r <= $y; $r++) {\n    for ($c=1; $c <= $x; $c++) {\n        if (rand(0,1) == 0) {\n            $rand = $w;\n        } else {\n            $rand = $b;\n        }\n        imagesetpixel($gd,$r,$c,$rand);\n    }\n}\n\nheader('Content-Type: image/png');\nimagepng($gd);