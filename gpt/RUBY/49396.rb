before_destroy :remove_email\n\ndef remove_email\n  self.email = "[deleted-#{self.id}]"\n  save(validate: false)\nend