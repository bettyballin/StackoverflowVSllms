Sys.Application.add_load(function() {\n    if (!AjaxControlToolkit.RatingBehavior.prototype._originalOnStarClick) {\n        AjaxControlToolkit.RatingBehavior.prototype._originalOnStarClick = \n            AjaxControlToolkit.RatingBehavior.prototype._onStarClick;\n    }\n\n    AjaxControlToolkit.RatingBehavior.prototype._onStarClick = function(e) {\n        // Check if the control is read-only\n        if (this._readOnly) {\n            return;\n        }\n        \n        // Always set the rating regardless of whether it's the same as the current rating\n        this.set_Rating(this._currentRating);\n    };\n});