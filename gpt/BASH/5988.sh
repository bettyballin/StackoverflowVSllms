#!/bin/bash\n\n# Function to echo HTML header and instructions\necho_header_and_instructions() {\n    cat <<EOF\nContent-Type: text/html\n\n<!DOCTYPE html>\n<html lang="en">\n<head>\n    <meta charset="UTF-8">\n    <meta name="viewport" content="width=device-width, initial-scale=1.0">\n    <title>Download</title>\n</head>\n<body>\n    <h1>Download Your Files</h1>\n    <p>Your configuration files and installer are being prepared. The download should start automatically.</p>\n    <script type="text/javascript">\n        window.onload = function() {\n            window.location.href = '/download';\n        };\n    </script>\n</body>\n</html>\nEOF\n}\n\n# Function to stream the files\nstream_files() {\n    echo "Content-Type: application/zip"\n    echo "Content-Disposition: attachment; filename=\"your_files.zip\""\n    echo\n    cat /path/to/your_files.zip\n}\n\n# Main script execution\nif [ "$REQUEST_URI" == "/download" ]; then\n    stream_files\nelse\n    echo_header_and_instructions\nfi