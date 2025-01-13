class Field( object ):\n    def __init__( self, name, size ):\n        self.name= name\n        self.size = size\n        self.offset= None\n\nclass Record( object ):\n    def __init__( self, fieldList ):\n        self.fields= fieldList\n        self.fieldMap= {}\n        offset= 0\n        for f in self.fields: \n            f.offset= offset\n            offset += f.size\n            self.fieldMap[f.name]= f\n    def parse( self, aLine ):\n        self.buffer= aLine\n    def get( self, aField ):\n        fld= self.fieldMap[aField]\n        return self.buffer[ fld.offset:fld.offset+fld.size+1 ]\n    def __getattr__( self, aField ):\n        return self.get(aField)