% tail -f /etc/motd &\n[1] 6033\n\n% pfiles 6033\n6033:   tail -f /etc/motd\n\n      Current rlimit: 256 file descriptors\n       0: S_IFREG mode:0644 dev:182,65538 ino:163065 uid:0 gid:3 size:54\n          O_RDONLY|O_LARGEFILE\n          /etc/motd\n       1: S_IFCHR mode:0620 dev:299,0 ino:718837882 uid:101 gid:7 rdev:24,3\n          O_RDWR|O_NOCTTY|O_LARGEFILE\n          /dev/pts/3\n       2: S_IFCHR mode:0620 dev:299,0 ino:718837882 uid:101 gid:7 rdev:24,3\n          O_RDWR|O_NOCTTY|O_LARGEFILE\n          /dev/pts/3