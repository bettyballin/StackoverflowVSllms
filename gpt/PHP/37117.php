<?php\n   $apiKey = 'your_api_key';\n   $url = 'http://example.com';\n   $apiUrl = "https://shot.screenshotapi.net/screenshot?token=$apiKey&url=$url";\n\n   // Call the API\n   $response = file_get_contents($apiUrl);\n\n   // Save the screenshot\n   $outputPath = '/path/to/save/screenshot.png';\n   file_put_contents($outputPath, $response);\n\n   echo "Screenshot saved successfully!";\n   ?>