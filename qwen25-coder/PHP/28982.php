// Fetch all polls and their answers in one query\n$results = $db->get_results("\n    SELECT p.pollID, p.pollQuestion, pa.pollAnswerID, pa.pollAnswerText\n    FROM poll p\n    INNER JOIN poll_answers pa ON p.pollID = pa.pollID\n", ARRAY_A);\n\n$polls = [];\nforeach ($results as $row) {\n    if (!isset($polls[$row['pollID']])) {\n        // Initialize the poll array\n        $polls[$row['pollID']] = [\n            'id' => $row['pollID'],\n            'question' => $row['pollQuestion'],\n            'answers' => []\n        ];\n    }\n    // Add answer to the corresponding poll\n    $polls[$row['pollID']]['answers'][] = [\n        'id' => $row['pollAnswerID'],\n        'text' => $row['pollAnswerText']\n    ];\n}\n\n// $polls now contains all polls with their answers nested within them.\nprint_r($polls);