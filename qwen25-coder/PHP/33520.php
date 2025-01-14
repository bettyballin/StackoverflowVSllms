$imageFilePath = $imageDir . $pk . '.jpg';\n\nif (!file_exists($imageFilePath) || filesize($imageFilePath) === 0) {\n    // Fetch the image data from the URL\n    $imageData = @file_get_contents($pic_url); // Suppress error with '@'\n\n    if ($imageData !== false && file_put_contents($imageFilePath, $imageData)) {\n        return $imageFilePath;\n    } else {\n        return 'removed.jpg';\n    }\n} else {\n    // File already exists and is not empty\n    return $imageFilePath;\n}