const template = Handlebars.compile('<div><img src="{{url}}" />{{name}}</div>');\nconst html = data.map((item) => template(item)).join('');\ncontainer.innerHTML = html;