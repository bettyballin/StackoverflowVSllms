#!/bin/bash\n\n# Define your variables\nUSER='foo'\nHOST='localhost'\n\n# Replace placeholders in deployment.sql with actual values and run the SQL commands\nsed "s/@USER@/$USER/g; s/@HOST@/$HOST/g" deployment.sql | mysql -u root -p