function isValidDateRange(requestedDate, startDate, endDate) {\n    const requestedDateObj = new Date(requestedDate);\n    const startDateObj = new Date(startDate);\n    const endDateObj = new Date(endDate);\n\n    return requestedDateObj >= startDateObj && requestedDateObj <= endDateObj;\n}\n\n// Example usage:\nconst requestedDate = '2023-03-15';\nconst startDate = '2023-03-13';\nconst endDate = '2023-03-17';\n\nconsole.log(isValidDateRange(requestedDate, startDate, endDate));  // Output: true