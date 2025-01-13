public event EventHandler MyEvent;\n\nprotected virtual void OnMyEvent(EventArgs e)\n{\n    // Get a copy of the event handlers to avoid race conditions\n    EventHandler handlers = MyEvent;\n\n    if (handlers != null)\n    {\n        // Use a Task to invoke the event handlers\n        Task.Run(() =>\n        {\n            handlers(this, e);\n        });\n    }\n}