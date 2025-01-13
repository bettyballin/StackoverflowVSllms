#!/bin/bash\n\n# Variables\nAPI_URL="https://addons.mozilla.org/api/v4/addons/"\nAPI_KEY="your_api_key"\nAPI_SECRET="your_api_secret"\nEXTENSION_PATH="path/to/your/extension.xpi"\n\n# Upload the extension\nresponse=$(curl -X POST \\n  -H "Authorization: JWT $(generate_jwt $API_KEY $API_SECRET)" \\n  -F "upload=@${EXTENSION_PATH}" \\n  "${API_URL}upload/")\n\n# Extract the upload UUID from the response\nupload_uuid=$(echo $response | jq -r '.uuid')\n\n# Check the status of the upload\nstatus="in_progress"\nwhile [ "$status" == "in_progress" ]; do\n  sleep 10\n  response=$(curl -X GET \\n    -H "Authorization: JWT $(generate_jwt $API_KEY $API_SECRET)" \\n    "${API_URL}upload/${upload_uuid}/")\n  status=$(echo $response | jq -r '.processed')\ndone\n\n# Download the signed extension\nif [ "$status" == "true" ]; then\n  file_url=$(echo $response | jq -r '.files[0].download_url')\n  curl -o signed_extension.xpi "$file_url"\n  echo "Extension signed and downloaded as signed_extension.xpi"\nelse\n  echo "Error: Extension could not be signed"\nfi