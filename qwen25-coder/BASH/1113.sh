sudo debugfs /dev/sdXN -w -R "dump <inum> /tmp/damaged_file"\n   # Corrupt the dumped file manually or use dd on specific parts.\n   sudo debugfs /dev/sdXN -w -R "write /tmp/corrupted_file <inum>"