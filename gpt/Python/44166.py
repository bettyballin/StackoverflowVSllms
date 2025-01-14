import os\nimport subprocess\nimport json\nimport numpy as np\n\ndef run_simulation(input_file, executable):\n    result = subprocess.run([executable, input_file], capture_output=True, text=True)\n    return result.stdout\n\ndef compare_outputs(output_old, output_new, tolerance=1e-6):\n    old_data = json.loads(output_old)\n    new_data = json.loads(output_new)\n    for key in old_data:\n        if not np.isclose(old_data[key], new_data[key], atol=tolerance):\n            return False, key, old_data[key], new_data[key]\n    return True, None, None, None\n\ndef main():\n    input_template = "input_template.txt"\n    old_executable = "old_simulation.exe"\n    new_executable = "new_simulation.exe"\n    \n    # Example range and step for input variables\n    variable_ranges = {\n        "variable1": (0.0, 1.0, 0.1),\n        "variable2": (10.0, 100.0, 10.0),\n        # Add other variables as needed\n    }\n    \n    for variable, (start, end, step) in variable_ranges.items():\n        for value in np.arange(start, end + step, step):\n            with open(input_template, 'r') as file:\n                input_data = file.read()\n            \n            # Modify the input data with the current variable value\n            input_data = input_data.replace(f"{{{{ {variable} }}}}", str(value))\n            \n            # Save to a temporary input file\n            with open("temp_input.txt", 'w') as file:\n                file.write(input_data)\n            \n            # Run both simulations\n            output_old = run_simulation("temp_input.txt", old_executable)\n            output_new = run_simulation("temp_input.txt", new_executable)\n            \n            # Compare results\n            match, key, old_value, new_value = compare_outputs(output_old, output_new)\n            if not match:\n                print(f"Discrepancy found for {variable}={value}: {key} old={old_value}, new={new_value}")\n            else:\n                print(f"Match for {variable}={value}")\n\nif __name__ == "__main__":\n    main()