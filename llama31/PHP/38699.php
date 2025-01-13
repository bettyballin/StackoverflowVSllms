// ...\n\n// Shuffle answers and store correct answer index\n$shuffledAnswers = array();\n$correctIndex = 0;\nforeach ($questions[$i][answers] as $answer) {\n    if ($answer[correct] == 1) {\n        $correctIndex = count($shuffledAnswers);\n    }\n    $shuffledAnswers[] = $answer;\n}\nshuffle($shuffledAnswers);\n\n// ...\n\n// Display answers\nfor ($c = 0; $c < sizeof($shuffledAnswers); $c++) {\n    echo "\n\t\t<span class=\"optionLine\">";\n    echo "<input type=\"radio\" name=\"question" . $questions[$i][id] . "\"";\n    echo " value=\"$c\" />";\n    echo $shuffledAnswers[$c][answer] . "</span>";\n}\n\n// ...\n\n// Check correct answer\nif ($_POST["$submittedName"] == $correctIndex) {\n    // Correct answer selected\n} else {\n    // Incorrect answer selected\n}