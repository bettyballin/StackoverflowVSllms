dtrace -n 'io:::start /args[1]->fi_addr == "<IP_ADDRESS>" && args[1]->fi_port == <PORT_NO>/ { @bytes[args[0]->b_bcount] = count(); }'