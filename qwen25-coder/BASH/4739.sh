# Mounting NFS using UDP (default for older versions)\nsudo mount -t nfs -o udp server:/exported/directory /mnt/nfs\n\n# Mounting NFS using TCP\nsudo mount -t nfs -o tcp server:/exported/directory /mnt/nfs_tcp