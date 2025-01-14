function someFunctionToOffsetEvents($events) {\n    $count = count($events);\n    \n    for ($i = 0; $i < $count; $i++) {\n        for ($j = $i + 1; $j < $count; $j++) {\n            // Check if events overlap\n            if (!($events[$j]['start'] >= $events[$i]['end'] || $events[$j]['end'] <= $events[$i]['start'])) {\n                // Mark both events as split\n                $events[$i]['split'] = true;\n                $events[$j]['split'] = true;\n            }\n        }\n    }\n    \n    return $events;\n}\n\n$events = array(\n  array(\n    "id" => 21,\n    "start" => 1242219600,\n    "end" => 1242237600,\n    "title" => "foo",\n    "split" => false\n  ),\n  array(\n    "id" => 22,\n    "start" => 1242223200,\n    "end" => 1242234000,\n    "title" => "foo",\n    "split" => false\n  )\n);\n\n$events = someFunctionToOffsetEvents($events);\nprint_r($events);