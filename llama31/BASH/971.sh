# Extract email headers from a PST file\nreadpst -e -o output_dir input.pst\n\n# Extract email headers from an mbox file\nmunpack -t -o output_dir input.mbox\n\n# Extract email metadata to CSV\nemail2csv -i input_email_file -o output.csv\n\n# Generate email statistics\nmailstat -i input_email_log -o output_stats.txt