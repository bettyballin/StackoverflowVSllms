from gi.repository import Gtk, WebKit2\n\nclass SimpleBrowser(Gtk.Window):\n    def __init__(self):\n        super().__init__(title="Simple Browser")\n\n        # Create a WebView\n        webview = WebKit2.WebView()\n\n        # Load local content or your desired UI HTML here\n        html_content = """\n        <html>\n            <body>\n                <h1>Hello from my embedded browser!</h1>\n            </body>\n        </html>\n        """\n\n        # Set the content to be loaded in the WebView\n        webview.load_html(html_content, base_uri="http://example.com")\n\n        self.add(webview)\n\ndef main():\n    Gtk.init(None)\n    browser = SimpleBrowser()\n    browser.show_all()\n    Gtk.main()\n\nif __name__ == "__main__":\n    main()