import pdfkit\n\n# Configuration for path to wkhtmltopdf (adjust as needed)\npath_wkthmltopdf = r'/usr/local/bin/wkhtmltopdf'\nconfig = pdfkit.configuration(wkhtmltopdf=path_wkthtmltopdf)\n\n# Convert HTML file to PDF\npdfkit.from_file('page.html', 'output.pdf', configuration=config)\n\n# Alternatively, convert a web page directly:\npdfkit.from_url('http://example.com/page.html', 'output_web.pdf', configuration=config)