function resizeImage($url, $maxWidth, $maxHeight) {\n    $img = getimagesize($url);\n    $width = $img[0];\n    $height = $img[1];\n\n    if ($width > $maxWidth || $height > $maxHeight) {\n        $ratio = min($maxWidth / $width, $maxHeight / $height);\n        $newWidth = (int) ($width * $ratio);\n        $newHeight = (int) ($height * $ratio);\n    } else {\n        $newWidth = $width;\n        $newHeight = $height;\n    }\n\n    return array($newWidth, $newHeight);\n}\n\n$url = 'https://example.com/image.jpg';\n$maxWidth = 250;\n$maxHeight = 300;\n\nlist($newWidth, $newHeight) = resizeImage($url, $maxWidth, $maxHeight);\n\necho '<img src="' . $url . '" width="' . $newWidth . '" height="' . $newHeight . '">';