from setuptools import setup, find_packages\n\nsetup(\n    name='foo',\n    version='0.1',\n    packages=find_packages(),\n    include_package_data=True,\n    package_data={\n        'foo.resources': ['*.png', '*.json'],\n    },\n)