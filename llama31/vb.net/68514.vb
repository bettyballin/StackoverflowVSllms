Dim checkbox\nDim waitTime\n\nwaitTime = 30 ' seconds\n\n' Wait for the checkbox to be clickable\nSet checkbox = Browser("yourBrowser").Page("yourPage").Frame("yourFrame").WebElement("yourCheckbox")\ncheckbox.WaitProperty "visible", True, waitTime\ncheckbox.WaitProperty "enabled", True, waitTime\n\n' Now attempt to click the checkbox\ncheckbox.Click