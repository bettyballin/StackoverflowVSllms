import types\n\ndef get_local_functions(func):\n    local_funcs = {}\n    \n    def tracer(frame, event, arg):\n        if event == 'call' and frame.f_code == func.__code__:\n            local_vars = frame.f_locals\n            for name, obj in local_vars.items():\n                if isinstance(obj, types.FunctionType) and obj.__code__.co_name in func.__code__.co_names:\n                    local_funcs[obj.__code__.co_name] = obj\n        return tracer\n    \n    import sys\n    sys.setprofile(tracer)\n    func()\n    sys.setprofile(None)\n    \n    return tuple(local_funcs[name] for name in func.__code__.co_names if name in local_funcs)\n\n# Example usage\nget, post = get_local_functions(f)\nget()\npost()