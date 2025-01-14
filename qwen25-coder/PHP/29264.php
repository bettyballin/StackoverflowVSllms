<?PHP\n// Source image URL (if using local path, change accordingly)\n$source_file_path = 'http://cache2.mycrib.net/images/image_group92/0/43/653807d5727a46498180e8ef57fdf7819b2b0c.jpg';\n// Watermark image (ensure this is a local file)\n$watermark_image = 'fpwatermark.gif'; \n// Destination file\n$destination_image = 'coooolgif.jpg';\n\n// Load the source file into memory if it's remote\n$image_data = file_get_contents($source_file_path);\n$tmp_source_img = tempnam(sys_get_temp_dir(), 'srcimg');\nfile_put_contents($tmp_source_img, $image_data);\n\n// Get image sizes\n$imagesize = getimagesize($tmp_source_img);\n$watermarksize = getimagesize($watermark_image);\n\n// Calculate watermark position\n$watermark_x = $imagesize[0] - $watermarksize[0] - 2;\n$watermark_y = $imagesize[1] - $watermarksize[1] - 2;\n\n// Run function\nif (watermark_img($tmp_source_img, $watermark_image, $watermark_x, $watermark_y, $destination_image)) {\n    echo "Watermark applied successfully.";\n} else {\n    echo "Failed to apply watermark.";\n}\n\nfunction watermark_img($image_src, $watermark_src, $watermark_x, $watermark_y, $output_file) {\n    // Determine what type of image we're working with\n    list($width, $height, $type) = getimagesize($image_src);\n    switch ($type) {\n        case IMAGETYPE_GIF:\n            $image = imagecreatefromgif($image_src);\n            break;\n        case IMAGETYPE_JPEG:\n            $image = imagecreatefromjpeg($image_src);\n            imageAlphaBlending($image, true);\n            break;\n        case IMAGETYPE_PNG:\n            $image = imagecreatefrompng($image_src);\n            imageAlphaBlending($image, true);\n            break;\n        default:\n            return false; // Unsupported format\n    }\n\n    // Create an instance of the watermark in memory\n    if (!($watermark = imagecreatefromgif($watermark_src))) {\n        return false; // Make sure your Watermark is a GIF or handle other formats\n    }\n\n    // Add watermark to the image\n    list(, , $watermark_width, $watermark_height) = getimagesize($watermark_src);\n    if (!imagecopy($image, $watermark, $watermark_x, $watermark_y, 0, 0, $watermark_width, $watermark_height)) {\n        return false;\n    }\n\n    // Save the image with the watermark now in place\n    switch ($type) { \n        case IMAGETYPE_GIF:\n            if (!imagegif($image, $output_file)) return false;\n            break;\n        case IMAGETYPE_JPEG:\n            if (!imagejpeg($image, $output_file)) return false;\n            break;\n        case IMAGETYPE_PNG: \n            if (!imagepng($image, $output_file)) return false;\n            break;\n    }\n\n    // Destroy instances of images to free up RAM\n    imagedestroy($image);\n    imagedestroy($watermark);\n\n    // Remove temporary source image if needed\n    unlink($image_src);\n\n    return true;\n}\n?>