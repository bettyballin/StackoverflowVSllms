from django.test import TestCase, Client\nfrom django.contrib.auth.models import User\nfrom myapp.models import MyModel\n\nclass AdminActionTestCase(TestCase):\n    def setUp(self):\n        self.client = Client()\n        self.superuser = User.objects.create_superuser('superuser', 'superuser@example.com', 'password')\n        self.client.login(username='superuser', password='password')\n\n    def test_admin_action(self):\n        # Create some test data\n        obj1 = MyModel.objects.create(name='Object 1')\n        obj2 = MyModel.objects.create(name='Object 2')\n\n        # Get the changelist page\n        response = self.client.get('/admin/myapp/mymodel/')\n\n        # Check that the action is available\n        self.assertContains(response, 'my_action')\n\n        # Post the action\n        post_data = {\n            'action': 'my_action',\n            '_selected_action': [obj1.id, obj2.id],\n        }\n        response = self.client.post('/admin/myapp/mymodel/', post_data)\n\n        # Check that the action was executed correctly\n        # This will depend on what your action actually does\n        self.assertEqual(response.status_code, 302)