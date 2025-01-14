import random\nimport pickle\nfrom django.core.files.base import ContentFile\nfrom myapp.models import Data  # Make sure to replace 'myapp' with your actual app name\n\n# Create an instance of Data model\ndata_entry = Data(label="somedata")\n\n# Generate and pickle the data\nsomedata = [random.random() for _ in range(10000)]\npickled_data = pickle.dumps(somedata)\n\n# Write pickled data to in-memory file-like object\nfilename = 'somedata.pkl'  # define a filename\ndata_entry.file.save(filename, ContentFile(pickled_data))