from google.appengine.ext import ndb\nfrom flask import request\n\nclass MyModel(ndb.Model):\n    field1 = ndb.StringProperty()\n    field2 = ndb.StringProperty()\n    field3 = ndb.StringProperty()\n    field4 = ndb.StringProperty()\n    field5 = ndb.StringProperty()\n\ndef handle_post():\n    # Assume request.form is a dictionary containing POST data\n    post_data = request.form.to_dict()\n    \n    # Filter out only the fields that are relevant to `MyModel`\n    model_properties = MyModel._properties\n    entity_data = {key: post_data[key] for key in post_data if key in model_properties}\n    \n    # Create or update the entity\n    entity = MyModel(**entity_data)\n    entity.put()\n\n    return "Entity saved successfully!", 200