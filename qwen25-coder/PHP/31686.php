<?php\n$query = $_GET['q'];\n$tags = ['javascript', 'python', 'java', 'c++', 'ruby', 'html', 'css'];\n\n$results = array_filter($tags, function($tag) use ($query) {\n    return stripos($tag, $query) !== false;\n});\n\necho json_encode(array_values($results));\n?>