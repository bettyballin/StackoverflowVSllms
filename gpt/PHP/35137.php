function is_animated_gif($filename) {\n    if (!($fh = @fopen($filename, 'rb'))) {\n        return false;\n    }\n\n    $count = 0;\n    // Read file until the end or until we find more than one frame\n    while (!feof($fh) && $count < 2) {\n        $chunk = fread($fh, 1024 * 100); // Read 100KB at a time\n        $count += preg_match_all('#\x00\x21\xF9\x04.{4}\x00\x2C#s', $chunk, $matches);\n    }\n\n    fclose($fh);\n    return $count > 1;\n}\n\n// Example usage\n$filename = 'path/to/your/image.gif';\nif (is_animated_gif($filename)) {\n    echo "The GIF is animated.";\n} else {\n    echo "The GIF is not animated.";\n}