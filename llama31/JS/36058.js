var event = new KeyboardEvent('keydown', {\n  bubbles: true,\n  cancelable: true,\n  keyCode: 9, // Tab key\n  key: 'Tab'\n});\n\nthis.input.focus();\nthis.input.dispatchEvent(event);