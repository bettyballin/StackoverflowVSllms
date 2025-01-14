from diff_match_patch import diff_match_patch\n\ndef create_diff(old_content, new_content):\n    dmp = diff_match_patch()\n    # Create patches from the differences between old_content and new_content.\n    diffs = dmp.diff_main(old_content, new_content)\n    # Convert diffs to HTML format.\n    dmp.diff_cleanupSemantic(diffs)\n    return dmp.diff_prettyHtml(diffs)\n\n# Example usage\nold_text = "This is a simple text with some words."\nnew_text = "This is an edited simple text with additional words and changes."\n\nhtml_diff = create_diff(old_text, new_text)\nprint(html_diff)