#!/bin/bash\n\n# Set variables\nRELEASE_BRANCH="release"\nSTAGING_SERVER="staging-server"\nPRODUCTION_SERVER="production-server"\n\n# Export latest revision from release branch\nsvn export --force --revision HEAD https://svn.example.com/repos/${RELEASE_BRANCH} /tmp/deploy\n\n# Create manifest file\nMANIFEST_FILE="/tmp/deploy/manifest.txt"\necho "Creating manifest file..."\nfor file in $(find /tmp/deploy -type f); do\n  echo "${file}" >> ${MANIFEST_FILE}\ndone\n\n# Deploy to staging server\nrsync -avz --files-from=${MANIFEST_FILE} /tmp/deploy/ ${STAGING_SERVER}:/var/www/\n\n# Test on staging server\n# ...\n\n# Deploy to production server\nrsync -avz --files-from=${MANIFEST_FILE} /tmp/deploy/ ${PRODUCTION_SERVER}:/var/www/