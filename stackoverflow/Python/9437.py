f = open('myfile.txt', 'w')\nfor x in range(255):\n    ip = "10.1.1.%s\n" % str(x)\n    f.write(ip)\nf.close()