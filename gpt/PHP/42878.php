function compose($type, $contents = null, $to = '', $cc = '') {\n    echo '\n        <tr>\n          <td>\n            <tr>\n              <td valign="top">\n                <form method="post" action="">\n                  <table width="100%" cellpadding="0" cellspacing="0" border="0" id="reply">\n                    <tr>\n                      <td><h2>' . htmlspecialchars($type) . '</h2></td>\n                    </tr>\n                    <tr>\n                      <td width="1%" valign="top" nowrap><b>To:</b><br><input name="to" id="focus" title="Enter a single system user here" value="' . htmlspecialchars($to) . '" type="text" size="64"></td>\n                    </tr>\n                    <tr>\n                      <td nowrap><b>Cc:</b><br><input name="cc" value="' . htmlspecialchars($cc) . '" type="text" size="64"></td>\n                    </tr>\n                    <tr>\n                      <td nowrap><b>Subject:</b><br><input name="subject" title="Enter your subject here" value="' . htmlspecialchars($contents['subject']) . '" type="text" size="64" maxlength="30"></td>\n                    </tr>\n                    <tr>\n                      <td valign="top"><b>Message:</b><br><textarea name="message" title="Enter your message here" rows="5" cols="50" wrap="virtual">' . htmlspecialchars($contents['message']) . '</textarea></td>\n                    </tr>\n                    <tr>\n                      <td>&nbsp;</td>\n                    </tr>\n                    <tr>\n                      <td>\n                        <input type="hidden" name="action_type" value="' . htmlspecialchars($type) . '">\n                        <input type="submit" name="send" value="Send">\n                      </td>\n                    </tr>\n                  </table>\n                </form>\n              </td>\n            </tr>\n          </td>\n        </tr>';\n\n    echo '<script>\n        document.addEventListener("DOMContentLoaded", function() {\n            var actionType = "' . htmlspecialchars($type) . '";\n            var toField = document.querySelector("input[name=\'to\']");\n            var ccField = document.querySelector("input[name=\'cc\']");\n            \n            if (actionType === "Forward") {\n                toField.value = "";\n                ccField.value = "";\n            } else if (actionType === "Reply") {\n                ccField.value = "";\n            } else if (actionType === "Reply to All") {\n                // Assume $cc contains the required email addresses for reply to all\n            }\n        });\n    </script>';\n}