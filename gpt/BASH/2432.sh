0 0 * * * find /home/get/public_html/videos -type f -name "*.flv" -mtime +1 -exec rm -f {} \;