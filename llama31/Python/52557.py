from distutils.core import setup\nimport py2exe\n\nsetup(\n    console=['your_script.py'],\n    options={\n        'py2exe': {\n            'dll_excludes': ['msvcr71.dll'],\n            'dll_includes': ['msvcp71.dll']\n        }\n    }\n)