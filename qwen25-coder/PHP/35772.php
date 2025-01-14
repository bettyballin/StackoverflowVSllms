function parseLinks($htmlContent, $baseUrl) {\n    // Regular expression to match <a href="URL">DESCRIPTION</a>\n    preg_match_all('/<a\s+(?:[^>]*?\s+)?href=\'([^\']*)\'>(.*?)<\/a>/is', $htmlContent, $matches);\n\n    $links = [];\n    foreach ($matches[1] as $index => $link) {\n        // Resolve the URL\n        $resolvedUrl = resolveUrl($baseUrl, $link);\n        \n        // Parse the resolved URL to determine if it's local or external\n        $parsedUrl = parse_url($resolvedUrl);\n        $parsedBase = parse_url($baseUrl);\n\n        // Check if it is a local link\n        $isLocal = ($parsedBase['host'] === $parsedUrl['host'] || !isset($parsedUrl['host'])) && \n                    (!isset($parsedUrl['scheme']) || $parsedBase['scheme'] == $parsedUrl['scheme']);\n        \n        // Store the result in the links array\n        $links[] = [\n            'url' => $resolvedUrl,\n            'desc' => strip_tags($matches[2][$index]),\n            'isLocal' => $isLocal\n        ];\n    }\n\n    return $links;\n}\n\nfunction resolveUrl($baseUrl, $url) {\n    // Check if the URL is already absolute\n    if (parse_url($url, PHP_URL_HOST)) {\n        return $url;\n    }\n    \n    // If not, resolve it\n    return preg_replace('@/[^/]*/\.\./@', '/', dirname($baseUrl).'/'.$url);\n}\n\n// Example usage\n$htmlContent = '<a href="page.html">Page 1</a><a href="../another_page.html">Another Page</a>';\n$baseUrl = 'http://example.com/folder/';\n\n$links = parseLinks($htmlContent, $baseUrl);\n\nprint_r($links);