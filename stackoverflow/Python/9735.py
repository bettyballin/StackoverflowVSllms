import codecs\n\ndata       = "Let's just pretend that this is binary data, ok?"\nuuencode   = codecs.getencoder("uu")\ndata_uu, n = uuencode(data)\nuudecode   = codecs.getdecoder("uu")\ndecoded, m = uudecode(data_uu)\n\nprint """* The initial input:\n%(data)s\n* Encoding these %(n)d bytes produces:\n%(data_uu)s\n* When we decode these %(m)d bytes, we get the original data back:\n%(decoded)s""" % globals()