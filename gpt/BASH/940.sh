# Add test files\nsudo mkdir /mnt/test/data\nsudo dd if=/dev/zero of=/mnt/test/data/file1 bs=1M count=10\nsudo dd if=/dev/zero of=/mnt/test/data/file2 bs=1M count=10\n\n# Sync and unmount the filesystem\nsudo sync\nsudo umount /mnt/test