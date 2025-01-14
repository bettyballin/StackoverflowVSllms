def estimate_column_width(header_text, avg_char_width=7, min_width=20):\n    """\n    Estimate the column width in pixels for PDF generation.\n    \n    :param header_text: The string of the column name or header text.\n    :param avg_char_width: Average pixel width per character based on font and size.\n    :param min_width: Minimum width to avoid very narrow columns.\n    :return: Estimated width in pixels.\n    """\n    estimated_width = len(header_text) * avg_char_width\n    return max(estimated_width, min_width)\n\n# Usage\ncolumn_widths = {}\nfor column_name in ['CompanyID', 'EmployeeName']:\n    column_widths[column_name] = estimate_column_width(column_name)\nprint(column_widths)