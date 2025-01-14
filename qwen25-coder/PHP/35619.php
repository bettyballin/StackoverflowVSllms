// CONNECT TO DB HERE\n\n$sub = new YomoSubscription(95, 783);\n$repeat = 10;\n$warmup = 5;\n\n// Warm up the cache and connection\nfor ($i = 0; $i < $warmup; $i++) {\n    $fp = $sub->generateFingerprint();\n}\n\n$times = [];\nfor ($i = 0; $i < $repeat; $i++) {\n    $t = microtime(TRUE);\n    $fp = $sub->generateFingerprint(); \n    $time_elapsed_secs = microtime(TRUE) - $t;\n    $times[] = $time_elapsed_secs;\n}\n\necho "Times: ";\nprint_r($times);\n$average_time = array_sum($times) / count($times);\necho "\nAverage query time: ". $average_time . " seconds\n";