<?php\n\nfunction getNextCronExecution($cronExpression, $timestamp) {\n    list($minute, $hour, $dayOfMonth, $month, $dayOfWeek) = explode(' ', $cronExpression);\n    $nextRunTimestamp = $timestamp;\n\n    do {\n        $dateTime = DateTime::createFromFormat('U', $nextRunTimestamp);\n        \n        // Check minute\n        if ($minute !== '*') {\n            $targetMinute = (int)$minute;\n            if ($dateTime->format('i') < $targetMinute) {\n                while ($dateTime->format('i') != $targetMinute) {\n                    $dateTime->modify('+1 minute');\n                }\n            } else {\n                $dateTime->modify('+1 hour')->setTime($hour === '*' ? 0 : $hour, $minute);\n            }\n        }\n\n        // Check hour\n        if ($hour !== '*') {\n            $targetHour = (int)$hour;\n            if ($dateTime->format('G') != $targetHour) {\n                $dateTime->modify("next hour")->setTime($targetHour, $minute === '*' ? 0 : $minute);\n            }\n        }\n\n        // Check day of month\n        if ($dayOfMonth !== '*') {\n            $targetDayOfMonth = (int)$dayOfMonth;\n            if ($dateTime->format('j') != $targetDayOfMonth) {\n                $dateTime->modify("first day of this month + {$targetDayOfMonth-1} days");\n                // Reset time after adjusting the day\n                if ($hour !== '*') $dateTime->setTime($hour, $minute === '*' ? 0 : $minute);\n            }\n        }\n\n        // Check month\n        if ($month !== '*') {\n            $targetMonth = (int)$month;\n            if ($dateTime->format('n') != $targetMonth) {\n                while ($dateTime->format('n') != $targetMonth) {\n                    $dateTime->modify('+1 month')->setDate($dateTime->format('Y'), $targetMonth, 1);\n                }\n            }\n        }\n\n        // Check day of week\n        if ($dayOfWeek !== '*') {\n            $targetDayOfWeek = (int)$dayOfWeek;\n            if ($dateTime->format('w') != $targetDayOfWeek) {\n                while ($dateTime->format('w') != $targetDayOfWeek) {\n                    $dateTime->modify('+1 day');\n                }\n            }\n        }\n\n        // Update next run timestamp\n        $nextRunTimestamp = $dateTime->getTimestamp();\n\n    } while($nextRunTimestamp <= $timestamp);\n\n    return $nextRunTimestamp;\n}\n\n// Example usage:\n$timestamp = time(); // Current timestamp\n$cronExpression = "2 5 * * *"; // Example cron expression: daily at 05:02\n\necho date('Y-m-d H:i:s', getNextCronExecution($cronExpression, $timestamp));