// assume 'element' is the element you want to manipulate\n// and 'newText' is the new text you want to insert\n\n// to replace text after the element\nelement.after(newText).next().remove();\n\n// to replace text before the element\nelement.before(newText).prev().remove();