class A(object):\n    def __init__( self, arg1, arg2 ):\n         etc.\n\nclass B(object):\n    def __init__( self, arg1, arg2 ):\n         etc.\n\nthing_to_make = A\nargList= ( some, pair )\nthing_to_make( *argList )\n\nthing_to_make = B\nargList- ( another, pair )\nthing_to_make( *argList )\n\ndef doSomething( class_, arg1, arg2 ):\n    thing= class_( arg1, arg2 )\n    thing.method()\n    print thing