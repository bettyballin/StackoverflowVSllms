function formatPostDate($timestamp) {\n    $currentDate = new DateTime();\n    $postDate = new DateTime("@$timestamp");\n\n    $interval = $currentDate->diff($postDate);\n\n    if ($interval->days == 0) {\n        return $postDate->format('H:i'); // return time of post\n    } elseif ($interval->days == 1) {\n        return 'yesterday';\n    } else {\n        return $interval->days . ' days ago';\n    }\n}\n\n// Example usage:\n$timestamp = 1643723400; // UNIX timestamp\necho formatPostDate($timestamp);