""" ProblemDemo.py\n    Chopped down from the paramiko demo file.\n\n    This code works in the shell but hangs when I try to import it!\n"""\nfrom time           import sleep\nimport os\n\nimport paramiko\n\nsOutputFilename     = "redacted.htm"  #-- The payload file\n\nhostname    = "redacted.com"\n####-- WARNING!  Embedded passwords!  Remove ASAP.\nsUsername   = "redacted"\nsPassword   = "redacted"\nsTargetDir  = "redacted"\n\ndef establish_sftp_connection():\n    #-- Get host key, if we know one.\n    hostkeytype = None\n    hostkey     = None\n    host_keys   = {}\n    try:\n        host_keys = paramiko.util.load_host_keys(os.path.expanduser('~/.ssh/known_hosts'))\n    except IOError:\n        try:\n            # try ~/ssh/ too, because windows can't have a folder named ~/.ssh/\n            host_keys = paramiko.util.load_host_keys(os.path.expanduser('~/ssh/known_hosts'))\n        except IOError:\n            print '*** Unable to open host keys file'\n            host_keys = {}\n\n    if host_keys.has_key(hostname):\n        hostkeytype = host_keys[hostname].keys()[0]\n        hostkey     = host_keys[hostname][hostkeytype]\n        print 'Using host key of type %s' % hostkeytype\n\n    ssh     = paramiko.Transport((hostname, 22))\n    ssh.connect(username=sUsername, password=sPassword, hostkey=hostkey)\n    sftp    = paramiko.SFTPClient.from_transport(ssh)\n    sftp.chdir (sTargetDir)\n    return sftp\n\ndef put_file(sftp):\n    sftp.put (sOutputFilename, sOutputFilename)\n\ndef close_connection(ssh):\n    ssh.close()\n\n# Usage\nsftp = establish_sftp_connection()\nput_file(sftp)\nclose_connection(sftp)