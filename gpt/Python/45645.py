content = """Error Report Submission\nFrom: First Last, email@example.com, 12345\nDate: 2009-04-16 04:33:31 pm Eastern\n\nThe content to be output starts here and can go on for any number of lines.\n"""\n\n# Split the content into lines\nlines = content.split("\n")\n\n# Remove the first four lines\nlines = lines[4:]\n\n# Join the remaining lines back together\ncleaned_content = "\n".join(lines)\n\nprint(cleaned_content)