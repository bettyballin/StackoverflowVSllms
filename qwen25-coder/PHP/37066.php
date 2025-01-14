// app/Shell/CleanupTmpImagesShell.php\nnamespace App\Shell;\n\nuse Cake\Console\Shell;\n\nclass CleanupTmpImagesShell extends Shell {\n    public function main() {\n        $tempPath = WWW_ROOT . 'files' . DS . 'tmp' . DS;\n        if (!file_exists($tempPath)) return;\n        \n        // Delete files older than 1 day\n        $files = scandir($tempPath);\n        foreach ($files as $file) {\n            if (in_array($file, ['.', '..'])) continue;\n            \n            $filePath = $tempPath . $file;\n            $mtime = filemtime($filePath);\n            $now = time();\n            \n            if ($now - $mtime > 86400) { // 1 day in seconds\n                unlink($filePath);\n            }\n        }\n    }\n}