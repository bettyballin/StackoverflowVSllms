exec("echo '[public_html]' >> /etc/samba/smb.conf");\nexec("echo '   path = /home/username/public_html' >> /etc/samba/smb.conf");\nexec("echo '   read only = no' >> /etc/samba/smb.conf");