lftp -u ftpuser:ftppass --socks5-hostname socks5://your-socks-proxy:1080 ftp://your-ftp-server/path/ -e "put file.txt; quit"