var fragment = document.createDocumentFragment();\nfragment.appendChild(newFreeformLabel);\nfragment.appendChild(newFreeformField);\nfragment.appendChild(newFreeformSpacer);\n\n// Insert the fragment at the beginning of the container\ncontainer.insertBefore(fragment, container.firstChild);