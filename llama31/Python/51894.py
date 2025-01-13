from formencode import Schema, FancyValidator\n\nclass UserForm(Schema):\n    name = FancyValidator.Text(not_empty=True)\n    email = FancyValidator.Email()\n\nclass UserSchema(Schema):\n    user = UserForm()