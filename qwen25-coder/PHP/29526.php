if ($handle = opendir($absolute_dir)) {\n    $image_array = array();\n\n    while (($file = readdir($handle)) !== false) {\n        if ($file != "." && $file != ".." && $file != ".svn" && $file != 'img') {\n            $image_info['url'] = $relative_dir . $file;\n            $image_info['filename'] = $file; // Store the filename for sorting\n            $image_array[] = $image_info; // Add each file to the array with its info\n        }\n    }\n    closedir($handle);\n\n    // Sort the images by filename, newest first, assuming names are sortable as dates\n    usort($image_array, function ($a, $b) {\n        return strcmp($b['filename'], $a['filename']);\n    });\n\n    // Limit to the 5 newest files\n    $image_array = array_slice($image_array, 0, 5);\n}