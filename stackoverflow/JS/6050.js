new Ajax.Request('example.html', {\n    parameters: {action: 'update'},\n    onSuccess: this.updateSuccessful\n});