import sys\nimport types\n\ndef trace_func(frame, event, arg):\n    if event == 'line':\n        local_vars = frame.f_locals\n        for var_name, var_value in local_vars.items():\n            print(f"{var_name} = {var_value} (type: {type(var_value)})")\n    return trace_func\n\ndef start_tracing():\n    sys.settrace(trace_func)\n\ndef stop_tracing():\n    sys.settrace(None)\n\nif __name__ == "__main__":\n    start_tracing()\n    \n    # Example variable assignments\n    x = 10\n    y = "hello"\n    z = [1, 2, 3]\n    \n    stop_tracing()