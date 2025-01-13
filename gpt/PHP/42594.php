<?php\n// Get the requested URI\n$requestUri = $_SERVER['REQUEST_URI'];\n\n// Remove any query string from the URI\n$requestPath = parse_url($requestUri, PHP_URL_PATH);\n\n// Split the URI into segments\n$segments = explode('/', trim($requestPath, '/'));\n\n// Assuming the structure is /stories/{id}/{title}\nif (count($segments) >= 2 && $segments[0] === 'stories') {\n    $storyId = $segments[1];\n    $storyTitle = isset($segments[2]) ? $segments[2] : '';\n\n    // Load the story from the database using the ID\n    // Assuming you have a function getStoryById($id) that retrieves the story\n    $story = getStoryById($storyId);\n\n    if ($story) {\n        echo "Story ID: " . htmlspecialchars($storyId) . "<br>";\n        echo "Story Title: " . htmlspecialchars($story['title']) . "<br>";\n        echo "Story Content: " . htmlspecialchars($story['content']) . "<br>";\n    } else {\n        echo "Story not found.";\n    }\n} else {\n    echo "Invalid URL.";\n}\n\n// Example function to retrieve story by ID\nfunction getStoryById($id) {\n    // Dummy data for example purposes\n    $stories = [\n        '1234' => ['title' => 'Man Invents Fire', 'content' => 'Once upon a time...']\n    ];\n\n    return isset($stories[$id]) ? $stories[$id] : null;\n}\n?>