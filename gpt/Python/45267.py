import os\nimport subprocess\n\n# Directory containing the PDF files\npdf_directory = "path/to/your/pdf_directory"\n\n# Get a list of PDF files in the directory\npdf_files = [f for f in os.listdir(pdf_directory) if f.endswith('.pdf')]\n\n# Sort the files in ascending order\npdf_files.sort()\n\n# Print each PDF file in order\nfor pdf_file in pdf_files:\n    pdf_path = os.path.join(pdf_directory, pdf_file)\n    print_command = f'rundll32.exe C:\\Windows\\System32\\shimgvw.dll,ImageView_PrintTo /pt "{pdf_path}" "YourPrinterName"'\n    subprocess.run(print_command, shell=True)\n\nprint("All PDF files have been sent to the printer.")