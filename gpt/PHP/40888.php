function getFinalUrl($url) {\n    $ch = curl_init($url);\n    curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true);\n    curl_setopt($ch, CURLOPT_NOBODY, true);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n    curl_exec($ch);\n    $finalUrl = curl_getinfo($ch, CURLINFO_EFFECTIVE_URL);\n    curl_close($ch);\n    return $finalUrl;\n}\n\n// Example usage\n$initialUrl = "http://foo.com";\n$finalUrl = getFinalUrl($initialUrl);\necho "Final URL: " . $finalUrl;