import redis\n   r = redis.Redis(host='localhost', port=6379, db=0)\n   r.set('foo', 'bar')\n   print(r.get('foo'))