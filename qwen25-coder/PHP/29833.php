// Sleep for 1 second every 100 iterations\n    $count = 0;\n    while ($condition) {\n        if (++$count % 100 == 0) {\n            sleep(1);\n        }\n        // Your processing code here\n    }