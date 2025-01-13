def proceed_button_clicked(self, button):\n    if self.updatePageRadio.get_active():\n        self.updatePage()\n    elif self.updatePostRadio.get_active():\n        self.updatePost()\n    elif self.pageRadio.get_active():\n        self.newPage()\n    elif self.blogRadio.get_active():\n        self.newBlogPost()\n    elif self.addSpaceRadio.get_active():\n        self.newSpace()\n    elif self.removePageRadio.get_active():\n        self.removePage()\n    elif self.removePostRadio.get_active():\n        self.removeBlogPost()\n    elif self.removeSpaceRadio.get_active():\n        self.removeSpace()\n\n# ...\n\nself.contentProceedButton.connect("clicked", self.proceed_button_clicked)