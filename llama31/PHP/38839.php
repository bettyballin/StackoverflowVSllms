// Flush after critical content\necho '<html><head>...</head><body>';\nflush();\n\n// Flush before external API call\necho '<div id="content">...</div>';\nflush();\n\n// Make external API call\n$data = api_call();\n\n// Output API response\necho '<div id="api-response">', $data, '</div>';