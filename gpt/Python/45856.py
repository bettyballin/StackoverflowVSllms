# script.py\nimport sys\n\ndef process_text(text):\n    # Example text processing\n    return text.upper()\n\nif __name__ == "__main__":\n    input_text = sys.argv[1]\n    result = process_text(input_text)\n    print(result)