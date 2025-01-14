<?php\n\n// Sample data\n$data = [\n    "results" => [\n        [\n            "text" => "4.2 #runlogger",\n            "to_user_id" => NULL,\n            "from_user" => "alexmcpherson",\n            "id" => 1459499489,\n            "from_user_id" => 4647988,\n            "iso_language_code" => "it",\n            "source" => "<a href=\"http://twitter.com/\">web</a>",\n            "profile_image_url" => "http://static.twitter.com/images/default_profile_normal.png",\n            "created_at" => "Sun, 05 Apr 2009 23:10:45 +0000"\n        ]\n        // Add more results as needed\n    ],\n    "since_id" => 0,\n    "max_id" => 1461841556,\n    "refresh_url" => "?since_id=1461841556&q=%23runlogger",\n    "results_per_page" => 15,\n    "total" => 1,\n    "completed_in" => 0.073063,\n    "page" => 1,\n    "query" => "%23runlogger"\n];\n\n$from_user = "alexmcpherson";  // The user to filter by\n$results = $data['results'];   // The results array\n$tally = [];                   // Array to hold the cleaned text values\n\nforeach ($results as $result) {\n    if ($result['from_user'] === $from_user) {\n        // Clean the 'text' field\n        $cleaned_text = str_replace('#runlogger', '', $result['text']);\n        // Trim any extra spaces\n        $cleaned_text = trim($cleaned_text);\n        // Add it to the tally array\n        $tally[] = $cleaned_text;\n    }\n}\n\n// Print the tally\nprint_r($tally);\n\n?>