this.initializeStep1 = function() {\n    var self = this;\n    PeopleServices.getFirstName(id, function(foundFirstName) {\n        self.initializeStep2(foundFirstName);\n    });\n}