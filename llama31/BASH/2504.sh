strace -f -p $(pgrep lighttpd) -e trace=memory