import time\ntime.strftime("%Y-%m-%d %H:%M:%S", \n              time.gmtime(time.mktime(time.strptime("2008-09-17 14:04:00", \n                                                    "%Y-%m-%d %H:%M:%S"))))