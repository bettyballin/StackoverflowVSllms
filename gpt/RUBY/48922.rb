<%= Ajax.ActionLink(\n        "Vote!", \n        "AddPictureVote", \n        "Vote", \n        new { id = Model.PictureId }, \n        new AjaxOptions { UpdateTargetId = "addvote" }, \n        new { @class = "vote-link", @title = "Vote!" }) %>