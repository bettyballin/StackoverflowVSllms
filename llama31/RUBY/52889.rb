# Using 'tap' to perform a side-effect on an object\n# without affecting the method chain\nuser.tap do |u|\n  u.name = 'John Doe'\n  u.save!\nend