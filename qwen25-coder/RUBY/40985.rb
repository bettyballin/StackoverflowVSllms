<p class="acp3">\n  <label>Status</label>\n  <select name="account[status]" id="account_status">\n    <option value="Active" <%= "selected" if account["status"] == "Active" %>>Active</option>\n    <option value="Disabled" <%= "selected" if account["status"] == "Disabled" %>>Disabled</option>\n  </select>\n</p>