$handle = fsockopen("tcp://xxx.xxx.xxx.xxx", 12345);\nfwrite($handle, "ls");\n$output = stream_get_contents($handle);\nfclose($handle);\necho $output;