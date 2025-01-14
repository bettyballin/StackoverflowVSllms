initialize: function() {\n    NDI.WebControls.Client.GenericAutoComplete.callBaseMethod(this, 'initialize');\n\n    // Get the behavior instance for the AutoCompleteExtender\n    var targetControl = $get(this._autoCompleteTargetControlID);\n    var autoCompleteBehavior = AjaxControlToolkit.AutoCompleteBehavior.getBehavior(targetControl);\n\n    if (autoCompleteBehavior) {\n        this._onClientPopulatingDelegate = Function.createDelegate(this, this.onClientPopulating);\n        this._onClientPopulatedDelegate = Function.createDelegate(this, this.onClientPopulated);\n\n        $addHandler(autoCompleteBehavior, 'populating', this._onClientPopulatingDelegate); // Use 'populating' event\n        $addHandler(autoCompleteBehavior, 'populated', this._onClientPopulatedDelegate);   // Use 'populated' event\n\n    } else {\n        Sys.Debug.fail("AutoCompleteBehavior not found for target control.");\n    }\n},\ndispose: function() {\n    // Remove handlers to prevent memory leaks\n    if (this._onClientPopulatingDelegate) $removeHandler(autoCompleteBehavior, 'populating', this._onClientPopulatingDelegate);\n    if (this._onClientPopulatedDelegate) $removeHandler(autoCompleteBehavior, 'populated', this._onClientPopulatedDelegate);\n\n    NDI.WebControls.Client.GenericAutoComplete.callBaseMethod(this, 'dispose');\n},\nonClientPopulating: function(sender, args) {\n    // Handle the populating event\n    console.log("Autocomplete is populating...");\n},\nonClientPopulated: function(sender, args) {\n    // Handle the populated event\n    console.log("Autocomplete has been populated.");\n}