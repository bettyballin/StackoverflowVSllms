import subprocess\n\ndef call_perl(function_name, *args):\n    result = subprocess.run(\n        ['perl', 'perl_script.pl', function_name] + list(args),\n        capture_output=True,\n        text=True,\n        check=True\n    )\n    return result.stdout.strip()\n\n# Example usage\noutput = call_perl('some_function', 'arg1', 'arg2')\nprint(output)