// predefined list of image qualities (higher number = best quality)\n// you can add more levels as you see fit\n$quality_levels = array(\n    260 => 4, \n    265 => 3, \n    600 => 2,\n    220 => 1\n);\n\n\nif ($image_arry) {\n\n    $best_image = null;\n\n    // first search for "-large" in filename \n    // because looping through array of strings is faster then getimagesize\n    foreach ($image_arry as $filename) {\n          if (strpos('-large', $filename) !== false) {\n                $best_image = $filename;\n                break;\n            }\n    }\n\n    // only do this loop if -large image doesn't exist\n    if ($best_image == null) {\n            $best_quality_so_far = 0;\n\n        foreach ($image_arry as $filename) {\n            $size = getimagesize($filename);\n            $width = $size[0];\n\n                    // translate width into quality level\n            $quality = $quality_levels[$width];\n\n            if ($quality > $best_quality_so_far) {\n                $best_quality_so_far = $quality;\n                $best_image = $filename;\n            }\n        }\n    }\n\n    // we should have best image now\n    if ($best == null) {\n        echo "no image found";\n    } else {\n        echo "best image is $best";\n    }\n}