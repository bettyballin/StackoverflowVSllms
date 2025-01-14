function formatPostDate($timestamp) {\n    $currentDate = new DateTime();\n    $postDate = DateTime::createFromFormat('U', $timestamp);\n    \n    // Difference between current date and post date\n    $interval = $currentDate->diff($postDate);\n    $daysAgo = $interval->days;\n\n    if ($postDate->format('Y-m-d') === $currentDate->format('Y-m-d')) {\n        return $postDate->format('g:i A'); // Return time of post in 12-hour format with AM/PM\n    } elseif ($daysAgo == 1) {\n        return 'yesterday';\n    } else {\n        return $daysAgo . ' days ago';\n    }\n}\n\n// Example usage:\n$timestamp = time() - (2 * 24 * 60 * 60); // Example timestamp for 2 days ago\necho formatPostDate($timestamp);