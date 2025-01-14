var ItemView = Backbone.View.extend({\n  template: _.template("<div><%= name %> - <%= description %></div>"),\n  render: function () {\n    this.$el.html(this.template(this.model.toJSON()));\n    return this;\n  }\n});