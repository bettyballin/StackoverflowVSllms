$.ajax({\n  type: 'GET',\n  url: '/protected-endpoint',\n  xhrFields: {\n    withCredentials: true\n  }\n});