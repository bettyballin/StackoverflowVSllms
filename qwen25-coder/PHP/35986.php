function getImageDimensions($url) {\n    ini_set('allow_url_fopen', 1); // Ensure that allow_url_fopen is enabled\n\n    $imageData = getimagesize($url);\n    if ($imageData === false) {\n        throw new Exception("Invalid image URL.");\n    }\n\n    list($originalWidth, $originalHeight) = $imageData;\n\n    $maxWidth = 250;\n    $maxHeight = 300;\n\n    $ratio = min($maxWidth / $originalWidth, $maxHeight / $originalHeight);\n\n    $finalWidth = (int) ($originalWidth * $ratio);\n    $finalHeight = (int) ($originalHeight * $ratio);\n\n    return [\n        'url' => htmlspecialchars($url),\n        'width' => $finalWidth,\n        'height' => $finalHeight\n    ];\n}\n\n$imageUrl = "http://example.com/image.jpg";\ntry {\n    $dimensions = getImageDimensions($imageUrl);\n} catch (Exception $e) {\n    echo 'Caught exception: ',  $e->getMessage(), "\n";\n}\n\necho '<img src="' . $dimensions['url'] . '" width="' . $dimensions['width'] . '" height="' . $dimensions['height'] . '">';