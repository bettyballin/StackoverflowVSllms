import { nanoid } from 'nanoid';\n\nfunction guidToNanoid(guid) {\n  const bytes = guid.split('-').map(x => parseInt(x, 16));\n  const number = BigInt(`0x${bytes.join('')}`);\n  return nanoid(8, number);\n}