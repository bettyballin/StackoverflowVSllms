function open($file){\n    $h = fopen($file, 'w');\n    if (!$h) {\n        throw new Exception("Failed to open file: " . $file);\n    }\n    return $h;\n}\n\nfunction write($file, $text){\n    try {\n        $h = $this->open($file);\n        fwrite($h, $text);\n        fclose($h); // Always close the handle\n    } catch (Exception $e) {\n        echo 'Error: ' . $e->getMessage();\n    }\n}