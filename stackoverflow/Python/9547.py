import time\n\ntry:\n    time.sleep(10)\nfinally:\n    print "clean up"\n    \nclean up\nTraceback (most recent call last):\n  File "<stdin>", line 2, in <module>\nKeyboardInterrupt