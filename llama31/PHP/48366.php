function is_process_running($pid) {\n    exec("ps $pid", $process_state);\n    return count($process_state) >= 2;\n}