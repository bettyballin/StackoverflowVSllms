\none ~ # nfsstat -m\n/ from /dev/root\n Flags: rw,vers=3,rsize=4096,wsize=4096,namlen=255,hard,nointr,nolock,proto=tcp,\ntimeo=600,retrans=2,sec=sys,addr=192.168.0.5\n\n/store/tv from 192.168.99.99:/store/tv\n Flags: rw,noatime,vers=3,rsize=524288,wsize=524288,namlen=255,hard,nointr,noloc\nk,proto=tcp,timeo=600,retrans=2,sec=sys,mountaddr=192.168.99.99,mountvers=3,mountp\nroto=tcp,addr=192.168.99.99\n\none ~ # time dd if=/dev/null of=/store/tv/test bs=16k count=10000\n10000+0 records in\n10000+0 records out\n163840000 bytes (164 MB) copied, 2.79913 s, 58.5 MB/s\n\nreal    0m3.048s\nuser    0m0.033s\nsys     0m1.983s\n\none pxelinux.cfg # time dd if=/store/tv/test of=/dev/null bs=16k\n154614+1 records in\n154614+1 records out\n2533208064 bytes (2.5 GB) copied, 56.4591 s, 44.9 MB/s\n\nreal    0m56.509s\nuser    0m0.163s\nsys     0m26.802s