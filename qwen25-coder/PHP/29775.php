$string = "This is a test string with brackets [ ]";\n$pattern = '/\]/';\n$replacement = 'REPLACED';\n$result = preg_replace($pattern, $replacement, $string);\n\necho $result;