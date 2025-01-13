import os\n\ndef is_called_from_cgi():\n    # Check for CGI-specific environment variables\n    if 'GATEWAY_INTERFACE' in os.environ:\n        return True\n    return False\n\nif __name__ == "__main__":\n    if is_called_from_cgi():\n        print("Called from CGI script")\n        # Handle CGI-specific logic here\n    else:\n        print("Called from the command line")\n        # Handle command-line specific logic here