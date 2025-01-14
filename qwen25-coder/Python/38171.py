from ftplib import FTP\n\nftpserver = "myserver"\nftpuser = "myuser"\nftppass = "mypwd"\n\nlocfile =  "g:/test/style.css"\nftpfile =  "/temp/style.css"\n\ntry:\n    ftp = FTP(ftpserver, ftpuser, ftppass)\nexcept Exception as e:\n    exit(f"Cannot connect: {e}")\n\nwith open(locfile, "rb") as f:\n    try:\n        ftp.delete(ftpfile)\n    except FileNotFoundError:\n        pass\n\n    # Explicitly set binary mode\n    ftp.sendcmd("TYPE I")\n\n    ftp.storbinary(f"STOR {ftpfile}", f)\n\nftp.dir(ftpfile)\nftp.quit()