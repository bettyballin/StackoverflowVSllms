document.getElementById('ctl00_ValidationSummary1').dispose = function() {\n    Array.remove(Page_ValidationSummaries, document.getElementById('ctl00_ValidationSummary1'));\n} /* This should end with a semicolon */\n(function() { var fn = function() { AjaxControlToolkit.ModalPopupBehavior.invokeViaServer('ctl00_c1_componentCategoryListUC_componentCategoryGrid_modalPopupExtender', true); Sys.Application.remove_load(fn);};Sys.Application.add_load(fn);})();