import csv\nimport io\n\ndef join_list_with_quotes(values):\n    output = io.StringIO()\n    writer = csv.writer(output, quoting=csv.QUOTE_MINIMAL)\n    writer.writerow(values)\n    # Strip the trailing newline character added by writerow\n    return output.getvalue().strip()\n\n# Example usage\nvalues = ['a', 'one "two" three', 'foo, bar', """both"'"""]\nresult = join_list_with_quotes(values)\nprint(result)