from cerberus import Validator\n\nschema = {\n    'name': {'type': 'string', 'required': True, 'minlength': 3},\n    'age': {'type': 'integer', 'required': True},\n    'email': {'type': 'string', 'required': True, 'regex': '^[\w\.-]+@[\w\.-]+\.\w+$'}\n}\n\nv = Validator()\ndocument = {'name': 'Al', 'age': 30, 'email': 'al@example.com'}\n\nif v.validate(document, schema):\n    print(v.document)\nelse:\n    print(v.errors)