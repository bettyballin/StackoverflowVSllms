class MyModel < ActiveResource::Base\n  self.site = OTHER_APP_URL\n  self.user = OTHER_APP_USER\n  self.password = OTHER_APP_PASSWORD\n\n  # Rest of the code here\nend