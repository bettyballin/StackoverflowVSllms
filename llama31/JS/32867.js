// Get the PageRequestManager instance\nvar prm = Sys.WebForms.PageRequestManager.getInstance();\n\n// Add a handler for the pageLoaded event\nprm.add_pageLoaded(function() {\n    // Re-initialize the WYSIWYG editor\n    nicEditors.allTextAreas();\n});