try {\n    fi.MoveTo(getHistoryFileName());\n} catch (IOException e) {\n    // Handle the IOException here, e.g., log it or take corrective action\n    e.printStackTrace();\n} finally {\n    Debug.Write("Move complete");\n}