Event.observe(window, 'load', init, false);\n\nfunction init() {\n    makeEditable('edit');\n}\n\nfunction makeEditable(className) {\n    var editElements = document.getElementsByClassName(className);\n    for (var i = 0; i < editElements.length; i++) {\n        let element = editElements[i]; // Use 'let' to create a block-scoped variable\n        Event.observe(element, 'click', function() { edit(element); }, false);\n        Event.observe(element, 'mouseover', function() { showAsEditable(element); }, false);\n        Event.observe(element, 'mouseout', function() { showAsEditable(element, true); }, false);\n    }\n}\n\nfunction showAsEditable(obj, clear) {\n    if (!clear) {\n        Element.addClassName(obj, 'editable');\n    } else {\n        Element.removeClassName(obj, 'editable');\n    }\n}\n\nfunction edit(obj) {\n    Element.hide(obj);\n\n    var textarea = '<div class="' + obj.className + '_editor"><textarea cols="60" rows="4" name="' + i + '" id="' + obj.id + '_edit">' + obj.innerHTML + '</textarea></div>';\n\n    var button = '<input type="button" value="SAVE" class="' + obj.className + '_save"/> OR <input type="button" value="CANCEL" class="' + obj.className + '_cancel"/>';\n\n    new Insertion.After(obj, textarea + button);\n\n    Event.observe(document.querySelector('.' + obj.className + '_save'), 'click', function() { saveChanges(obj); }, false);\n    Event.observe(document.querySelector('.' + obj.className + '_cancel'), 'click', function() { cleanUp(obj); }, false);\n}\n\nfunction cleanUp(obj) {\n    Element.remove(document.querySelector('.' + obj.className + '_editor'));\n    Element.show(obj);\n    showAsEditable(obj, true);\n}\n\nfunction saveChanges(obj) {\n    var new_content = escape($F(obj.id + '_edit'));\n\n    obj.preUpdate = obj.innerHTML; // stow contents prior to saving in case of an error\n    obj.innerHTML = "Saving…";\n    cleanUp(obj);\n\n    var success = function(t) { editComplete(t, obj); };\n    var failure = function(t) { editFailed(t, obj); };\n\n    var url = 'http://portal.3roadsmedia.com/scripts/edit.php';\n    var pars = 'id=' + i + '&content=' + new_content + '&pre=' + escape(obj.preUpdate);\n    var myAjax = new Ajax.Request(url, {method: 'post', postBody: pars, onSuccess: success, onFailure: failure});\n}\n\nfunction editComplete(t, obj) {\n    obj.innerHTML = t.responseText;\n    showAsEditable(obj, true);\n}\n\nfunction editFailed(t, obj) {\n    obj.innerHTML = 'Sorry, the update failed.';\n    cleanUp(obj);\n}