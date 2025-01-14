from functools import partial\n\nclass A(object):\n    def hello(self, salutation):\n        print('%s, my name is %s' % (salutation, str(self)))\n\n    def bind_hello(self):\n        return partial(self.hello)\n\na1, a2 = A(), A()\na1.hello('Greetings'); a2.hello('Greetings')\n\nf1, f2 = a1.bind_hello(), a2.bind_hello()\nf1('Salutations'); f2('Salutations')