$biggest = 0;\n$biggest_start = 0;\n\nfunction test($i, $start = null, $counter = 0) {\n    global $biggest;\n    global $biggest_start;\n    \n    if ($start === null) {\n        $start = $i;\n    }\n    \n    if ($i == 1) {\n        if ($counter > $biggest) {\n            $biggest = $counter;\n            $biggest_start = $start;\n        }\n    } else {\n        if ($i % 2 == 0) {\n            test($i / 2, $start, $counter + 1);\n        } else {\n            test(3 * $i + 1, $start, $counter + 1);\n        }\n    }\n}\n\ntest(13);\necho "Biggest steps: $biggest, starting from: $biggest_start";