function projectListToTree($projects) {\n    $root = null;\n    $stack = Array();\n    for($x = 0; $x < count($projects); $x++) {\n        $project = $projects[$x];\n        $project['Children'] = Array();\n\n        while(count($stack) > 0 && $stack[count($stack) - 1]['Right'] < $project['Right']) {\n            array_pop($stack);\n        }\n\n        if(count($stack) > 0) {\n            $stack[count($stack) - 1]['Children'][] = $project; \n            echo "Adding " . $project['Name'] . " to " . $stack[count($stack) - 1]['Name'] . " for a total of "\n                . count($stack[count($stack) - 1]['Children']) . " kids\n";\n        } else {\n            echo "No parent\n"; \n            $root = $project;\n        }\n\n        echo "stack count: " . count($stack) . "\n";\n\n        array_push($stack, $project);\n    }\n\n    echo "Left in stack: " . count($stack) . "\n";\n\n    return $root;\n}