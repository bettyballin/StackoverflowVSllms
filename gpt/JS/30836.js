var feedback = function() {\n    new Ajax.Updater('feedback', 'contact.php', {\n        method: 'post',\n        parameters: Form.serialize($('contactForm')),\n        onFailure: reportError\n    });\n\n    new Effect.Highlight('feedback', {\n        duration: 1\n    });\n}\n\n// Use setTimeout to delay the execution of the feedback function\nsetTimeout(feedback, 1500);