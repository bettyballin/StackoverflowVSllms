if (file_exists('../images/' . $pk . '.jpg')) {\n    $imageSrc = htmlspecialchars("../images/" . $pk . ".jpg");\n    $imagehtmlSafe = htmlspecialchars("<img src='$imageSrc'>"); // Use single quotes for HTML attribute\n\n    // Escape JSON data for use in inline JavaScript strings\n    $imagehtmlJsonEscaped = json_encode($imagehtmlSafe);\n\n    $screenshotLink = "<p><a href=\"#\" onclick=\"makewindows(" . $imagehtmlJsonEscaped . "); return false;\">View Screenshot</a></p>";\n} else {\n    $screenshotLink = '';\n}