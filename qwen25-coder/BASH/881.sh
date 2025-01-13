#!/bin/bash\n\n# Define the directory containing the PDFs\ndir="/path/to/your/pdfs"\n\n# Loop through all PDF files in alphabetical order and print them\nfor file in "$dir"/*.pdf; do\n    lp "$file"\ndone