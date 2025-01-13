# 1. Create an encrypted volume (assuming sd2 for disk and d for partition)\nbioctl -c C -l /dev/sd2d -P pbkdf2 aes-xts\n\n# 2. Follow the on-screen instructions to create a passphrase, then note or remember the assigned sdX device.\n\n# 3. Create a file system\nnewfs /dev/rrsdXc # Replace X with your bioctl-assigned letter.\n\n# 4. Mount the file system\nmount /dev/sdXc /mnt # Replace X with your bioctl-assigned letter.\n\n# For unmounting and detaching, simply use:\numount /mnt\nbioctl -d sdX # Replace X with your bioctl-assigned letter.