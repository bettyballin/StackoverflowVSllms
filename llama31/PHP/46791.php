$input = 'Hello, World!';\nexec('java -jar AiProcessor.jar ' . escapeshellarg($input), $output, $return_var);\necho $output;