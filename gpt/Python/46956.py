# Define the error codes and messages\nerror_codes = {\n    "A01": "whatever error",\n    "U01": "another error",\n    "U02": "yet another error type"\n}\n\ndef get_error_message(code):\n    return error_codes.get(code, "Unknown error code")\n\n# Example usage\ncode = "U01"\nprint(f"Error message for {code}: {get_error_message(code)}")