# eggs/__init__.py\nfrom . import foo\nfrom . import bar\n\n# eggs/foo/__init__.py\nfrom . import a\n\n# eggs/bar/a.py\nfrom eggs import foo