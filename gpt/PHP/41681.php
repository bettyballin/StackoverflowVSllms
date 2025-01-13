function getTime() {\n    $timer = explode(' ', microtime());\n    return $timer[1] + $timer[0];\n}\n\nfunction createThumb($thumb, $ids){\n    $start = getTime();\n\n    // File and new size\n    $filename = $thumb;\n    $img1 = getimagesize($filename);\n\n    // Determine new dimensions\n    $percentage = ($img1[0] > $img1[1]) ? (72 / $img1[0]) : (72 / $img1[1]);\n    $new_width = $img1[0] * $percentage;\n    $new_height = $img1[1] * $percentage;\n\n    // Create resampled image\n    $image_p = imagecreatetruecolor($new_width, $new_height);\n\n    if ($img1['mime'] == 'image/png') {\n        $image = imagecreatefrompng($filename);\n        imagealphablending($image_p, false);\n        imagesavealpha($image_p, true);\n        $transparent = imagecolorallocatealpha($image_p, 255, 255, 255, 127);\n        imagefilledrectangle($image_p, 0, 0, $new_width, $new_height, $transparent);\n    } else {\n        $image = imagecreatefromjpeg($filename);\n    }\n\n    imagecopyresampled($image_p, $image, 0, 0, 0, 0, $new_width, $new_height, $img1[0], $img1[1]);\n\n    // Define paths and names\n    $imgPath = '/foo/bar/location/' . $ids;\n    if (!is_dir($imgPath)) {\n        mkdir($imgPath, 0777, true);\n    }\n\n    if (!file_exists($imgPath . "/index.html")) {\n        file_put_contents($imgPath . "/index.html", '<html><body>401</body></html>');\n    }\n\n    $name = rand(1, 156406571337);\n    $imgName = date("y_m_d_h_m_s") . $name . ($img1['mime'] == 'image/png' ? '.png' : '.jpg');\n\n    // Output the image\n    if ($img1['mime'] == 'image/png') {\n        imagepng($image_p, $imgPath . '/' . $imgName);\n    } else {\n        imagejpeg($image_p, $imgPath . '/' . $imgName, 100);\n    }\n\n    imagedestroy($image_p);\n    imagedestroy($image);\n\n    $end = getTime();\n    echo '<strong>createImage</strong>: ' . round($end - $start, 4) . ' seconds<br />';\n\n    return $imgName;\n}