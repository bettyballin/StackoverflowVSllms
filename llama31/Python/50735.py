def save(self):\n    super(Attachment, self).save()\n    self.message.updated = timezone.now()  # Use timezone.now() to get the current time\n    self.message.save()  # Save the Message instance to update the database