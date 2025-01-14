class RoundScore {\n    public $Round_Name;\n    public $Player_Name;\n    public $Score;\n}\n\n$scores = array();\n\n// Bob round 1\n$s = new RoundScore();\n$s->Round_Name = 'Round 1';\n$s->Player_Name = 'Bob';\n$s->Score = 10;\n$scores[] = $s;\n\n// Bob round 2\n$s = new RoundScore();\n$s->Round_Name = 'Round 2';\n$s->Player_Name = 'Bob';\n$s->Score = 7;\n$scores[] = $s;\n\n// Jack round 1\n$s = new RoundScore();\n$s->Round_Name = 'Round 1';\n$s->Player_Name = 'Jack';\n$s->Score = 6;\n$scores[] = $s;\n\n// Jack round 2\n$s = new RoundScore();\n$s->Round_Name = 'Round 2';\n$s->Player_Name = 'Jack';\n$s->Score = 12;\n$scores[] = $s;\n\n// Organize scores by player and round\n$organizedScores = [];\nforeach ($scores as $score) {\n    $player = $score->Player_Name;\n    $round = $score->Round_Name;\n\n    if (!isset($organizedScores[$player])) {\n        $organizedScores[$player] = ['Total' => 0];\n    }\n    $organizedScores[$player][$round] = $score->Score;\n    $organizedScores[$player]['Total'] += $score->Score;\n}\n\n// Get all unique round names\n$rounds = [];\nforeach ($scores as $score) {\n    if (!in_array($score->Round_Name, $rounds)) {\n        $rounds[] = $score->Round_Name;\n    }\n}\n\n// Output the pivot table\necho "Player  " . implode("  ", $rounds) . "  Total\n";\necho str_repeat("-", 30) . "\n";\n\nforeach ($organizedScores as $player => $data) {\n    echo $player . "  ";\n    foreach ($rounds as $round) {\n        echo (isset($data[$round]) ? $data[$round] : 0) . "  ";\n    }\n    echo $data['Total'] . "\n";\n}\n?>