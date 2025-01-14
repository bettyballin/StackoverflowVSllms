import gi\ngi.require_version('Gtk', '3.0')\nfrom gi.repository import Gtk, GLib\nimport threading\nimport pycurl\nfrom io import BytesIO\n\nclass UploadWindow(Gtk.Window):\n    def __init__(self):\n        super().__init__(title="File Uploader")\n        \n        self.progress_bar = Gtk.ProgressBar()\n        self.add(self.progress_bar)\n\n        self.connect("delete-event", Gtk.main_quit)\n        self.show_all()\n\n    def start_upload(self, file_path):\n        thread = threading.Thread(target=self.upload_file, args=(file_path,))\n        thread.start()\n\n    def upload_file(self, file_path):\n        buffer = BytesIO()\n        c = pycurl.Curl()\n        c.setopt(c.URL, 'https://example.com/upload')\n        c.setopt(c.READDATA, open(file_path, 'rb'))\n        \n        # Simulate long operation\n        def progress(download_total, downloaded, upload_total, uploaded):\n            if upload_total > 0:\n                GLib.idle_add(self.update_progress, uploaded / upload_total)\n\n        c.setopt(pycurl.NOPROGRESS, 0)\n        c.setopt(pycurl.XFERINFOFUNCTION, progress)\n        c.perform()\n        c.close()\n\n    def update_progress(self, fraction):\n        self.progress_bar.set_fraction(fraction)\n        if fraction == 1.0:\n            print("Upload complete!")\n        return True\n\ndef main():\n    window = UploadWindow()\n    window.start_upload('/path/to/your/file')\n    Gtk.main()\n\nif __name__ == "__main__":\n    main()