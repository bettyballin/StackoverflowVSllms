function Start() {\n    var control = document.getElementById("silverlightControl");\n    if (control.Content != null && control.Content.Page) {\n        control.Content.Page.Start();\n    } else {\n        console.error("Silverlight object not fully loaded or 'Page' not registered.");\n    }\n}\n\nfunction Stop() {\n    var control = document.getElementById("silverlightControl");\n    if (control.Content != null && control.Content.Page) {\n        control.Content.Page.Stop();\n    } else {\n        console.error("Silverlight object not fully loaded or 'Page' not registered.");\n    }\n}