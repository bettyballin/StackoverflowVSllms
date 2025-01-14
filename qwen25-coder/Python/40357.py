import os\n   from django.utils.deconstruct import deconstructible\n\n   @deconstructible\n   class UploadToPathAndRename(object):\n       def __init__(self, path):\n           self.sub_path = path\n\n       def __call__(self, instance, filename):\n           ext = filename.split('.')[-1]\n           filename = f"{uuid.uuid4()}.{ext}"\n           return os.path.join(self.sub_path, filename)