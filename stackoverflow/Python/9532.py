import StringIO\nimport sys\n\n\nsys.stdout = StringIO.StringIO()\nprint "foo", "bar", "baz"\ns = sys.stdout.getvalue()