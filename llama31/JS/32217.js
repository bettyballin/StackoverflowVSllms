const wasmModule = await WebAssembly.instantiateStreaming(fetch('hello.wasm'));\nconst helloFunc = wasmModule.instance.exports.hello;\nhelloFunc();