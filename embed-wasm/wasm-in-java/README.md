# [WebAssembly](https://webassembly.org/) in Java

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/eleftherias/wasm-examples)


This Java example calculates the 8th Fibonacci number using the WebAssembly binary `fibonacci.wasm`.
This is made possible by leveraging [wasmtime-java](https://github.com/kawamuray/wasmtime-java).

Run the application using:
```
./gradlew run
```

For simplicity, the `fibonacci.wasm` binary was included in the source code. 

You can also generate it yourself from the Rust fibonacci project.

Start by changing into the `to-wasm/rust-to-wasm` directory.
```
cd ../../to-wasm/rust-to-wasm
```

Then, build the library:
```
cargo build --target wasm32-wasi --release
```

Optional: You can further optimize the generated file using the `wasm-opt` command:
```
wasm-opt target/wasm32-wasi/release/rust_to_wasm.wasm -o fibonacci.wasm  -O
```

Finally, replace `embed-wasm/wasm-in-java/fibonacci.wasm` with the newly generated wasm file:
```
cp fibonacci.wasm ../../embed-wasm/wasm-in-java
```
 and re-run the application:
```
./gradlew run
```