from django.db import transaction\n\nclass MyTestCase(TestCase):\n    def test_my_test(self):\n        with transaction.atomic():\n            # Your test code here\n            pass