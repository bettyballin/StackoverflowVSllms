#!/bin/bash\n\n# Download the file using wget\nwget http://domain/file.zip\n\n# Check if wget completed successfully\nif [ $? -eq 0 ]; then\n   # Run the MySQL query\n   mysql -u your_username -p your_password -e "UPDATE table SET status = 'live' WHERE id = '1234';"\nfi