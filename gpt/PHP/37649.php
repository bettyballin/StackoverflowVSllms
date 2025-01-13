function reSizePic($image)\n{\n    $max_width = 660;\n    $max_height = 500;\n\n    list($width, $height, $type) = getimagesize($image);\n\n    switch ($type) {\n        case IMAGETYPE_JPEG:\n            $src = imagecreatefromjpeg($image);\n            break;\n        case IMAGETYPE_PNG:\n            $src = imagecreatefrompng($image);\n            break;\n        case IMAGETYPE_GIF:\n            $src = imagecreatefromgif($image);\n            break;\n        default:\n            return; // Unsupported image type\n    }\n\n    $x_ratio = $max_width / $width;\n    $y_ratio = $max_height / $height;\n\n    if (($width <= $max_width) && ($height <= $max_height)) {\n        $tn_width = $width;\n        $tn_height = $height;\n    } elseif (($x_ratio * $height) < $max_height) {\n        $tn_height = ceil($x_ratio * $height);\n        $tn_width = $max_width;\n    } else {\n        $tn_width = ceil($y_ratio * $width);\n        $tn_height = $max_height;\n    }\n\n    $tmp = imagecreatetruecolor($tn_width, $tn_height);\n    imagecopyresampled($tmp, $src, 0, 0, 0, 0, $tn_width, $tn_height, $width, $height);\n\n    switch ($type) {\n        case IMAGETYPE_JPEG:\n            imagejpeg($tmp, $image, 100);\n            break;\n        case IMAGETYPE_PNG:\n            imagepng($tmp, $image);\n            break;\n        case IMAGETYPE_GIF:\n            imagegif($tmp, $image);\n            break;\n    }\n\n    imagedestroy($src);\n    imagedestroy($tmp);\n}