class Something( object ):\n    def __init__( self ):\n        self.a= 2\n        self.b= 3\n\nx= Something()\ngetattr( x, 'a' )\ngetattr( x, 'b' )