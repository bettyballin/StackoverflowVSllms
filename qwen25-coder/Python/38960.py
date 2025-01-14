from google.appengine.ext import db\n\nclass Summary(webapp.RequestHandler):\n    def get(self):\n        groups_query = Groups.all()\n        groups = groups_query.fetch(1000)\n        \n        # Fetch related topics for each group\n        for group in groups:\n            group.topics = group.topics.filter('topic_group =', group).fetch(1000)\n        \n        template_values = {\n            'groups': groups,\n        }\n\n        path = os.path.join(os.path.dirname(__file__), 'summary.html')\n        self.response.out.write(template.render(path, template_values))