$fileId = '1234567890abcdef';\n    $hash = md5($fileId);\n    $dirPath = 'files/' . substr($hash, 0, 2) . '/' . substr($hash, 2, 2) . '/';