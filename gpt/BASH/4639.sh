mkfs -q /dev/ram1 1024\n    mkdir /mnt/ramdisk\n    mount /dev/ram1 /mnt/ramdisk\n    cp dump.sql /mnt/ramdisk/\n    mysql -u username -p database < /mnt/ramdisk/dump.sql