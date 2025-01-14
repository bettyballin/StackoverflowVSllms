class Dstorage(Fuse, Distributor):\n    def get_file(self, server, path, flags, *mode):\n        # Create and return an instance of your file handling class here\n        return XmpFile(path)  # Assuming XmpFile is the class you intend to use\n\n    def main(self, *a, **kw):\n        self.file_class = XmpFile  # Set this to your file class\n        return Fuse.main(self, *a, **kw)