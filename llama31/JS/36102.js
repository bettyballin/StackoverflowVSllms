const key = await crypto.subtle.generateKey(\n  {\n    name: "AES-GCM",\n    length: 256,\n  },\n  true,\n  ["encrypt", "decrypt"]\n);\n\nconst encrypted = await crypto.subtle.encrypt(\n  {\n    name: "AES-GCM",\n    iv: new Uint8Array(12),\n  },\n  key,\n  new TextEncoder().encode("Message")\n);