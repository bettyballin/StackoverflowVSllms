var quill = new Quill('#textarea', {\n  modules: {\n    toolbar: [\n      ['bold', 'italic', 'underline'],\n      ['list', 'bullet'],\n      ['link']\n    ]\n  },\n  placeholder: 'Type here...',\n  theme: 'snow'\n});