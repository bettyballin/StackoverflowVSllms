function convertAtomDate($atomDate) {\n    $date = new DateTime($atomDate);\n    $interval = $date->diff(new DateTime('now'));\n    $seconds = $interval->s;\n    $minutes = $interval->i;\n    $hours = $interval->h;\n    $days = $interval->d;\n\n    if ($days > 0) {\n        return $days . ' day' . ($days > 1 ? 's' : '') . ' ago';\n    } elseif ($hours > 0) {\n        return $hours . ' hour' . ($hours > 1 ? 's' : '') . ' ago';\n    } elseif ($minutes > 0) {\n        return $minutes . ' minute' . ($minutes > 1 ? 's' : '') . ' ago';\n    } else {\n        return $seconds . ' second' . ($seconds > 1 ? 's' : '') . ' ago';\n    }\n}\n\n$atomDate = '2008-11-03T21:30:06Z';\necho convertAtomDate($atomDate);