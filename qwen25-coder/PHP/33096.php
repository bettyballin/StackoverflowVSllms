function compose($type, $contents = null)\n{\n    // Determine initial values based on the action type\n    $to = '';\n    $cc = '';\n    if ($type === 'Reply to all') {\n        $cc = (isset($contents['cc'])) ? implode(', ', $contents['cc']) : ''; // Assuming cc addresses are in an array\n    }\n    if ($type === 'Forward') {\n        $to = '';\n        $cc = '';\n    }\n\n    echo '\n    <tr>\n      <td>\n        <form method="post" action="">\n          <table width="100%" cellpadding="0" cellspacing="0" border="0" id="reply">\n            <tr>\n              <td><h2>' . htmlspecialchars($type) . '</h2></td>\n            </tr>\n            <tr>\n              <td width="1%" valign="top" nowrap><b>To:</b><br><input name="to" id="focus" title="Enter a single system user here" value="' . htmlspecialchars($to) . '" type="text" size="64"></td>\n            </tr>\n            <tr>\n              <td nowrap><b>Cc:</b><br><input name="cc" value="' . htmlspecialchars($cc) . '" type="text" size="64"></td>\n            </tr>\n            <tr>\n              <td nowrap><b>Subject:</b><br><input name="subject" title="Enter your subject here" value="' . (isset($contents['subject']) ? htmlspecialchars($contents['subject']) : '') . '" type="text" size="64" maxlength="30"></td>\n            </tr>\n            <tr>\n              <td valign="top"><b>Message:</b><br><textarea name="message" title="Enter your message here" rows="5" cols="50" wrap="virtual">' . (isset($contents['message']) ? htmlspecialchars($contents['message']) : '') . '</textarea></td>\n            </tr>\n            <tr>\n              <td>&nbsp;</td>\n            </tr>\n            <tr>\n              <td>\n                <input type="hidden" name="action_type" value="' . htmlspecialchars($type) . '">\n                <input type="hidden" name="id" value="' . (isset($contents['id']) ? htmlspecialchars($contents['id']) : '') . '">\n                <input type="submit" name="send" value="Send">\n              </td>\n            </tr>\n          </table>\n        </form>\n      </td>\n    </tr>';\n}