// Assuming 'message.ENC[0][9][1]' is where your event type (A28, A31, etc.) is located\n\nvar eventType = msg['ENC']['Event Code']['Value'].toString();\n\n// Determine the operation name based on the HL7 event type\nvar operationName;\nswitch(eventType) {\n    case 'A28':\n        operationName = 'AddPerson';\n        break;\n    case 'A31':\n        operationName = 'UpdatePerson';\n        break;\n    case 'A29':\n        operationName = 'DeletePerson';\n        break;\n    // Add cases for other event types and their corresponding operations\n    default:\n        throw 'Unknown HL7 Event Type: ' + eventType;\n}\n\n// Set the operation name in the message meta data that SOAP Sender can pick up\nchannelMap.put('operationName', operationName);