# Rust to [WebAssembly](https://webassembly.org/)

This example provides a Rust library with a `fibonacci` function that calculates the n-th Fibonacci number.

Start by building the library:
```
cargo build --target wasm32-wasi --release
```

This produces a `rust_to_wasm.wasm` in `target/wasm32-wasi/release/`.

You can then invoke the `fibonacci` function with an argument (e.g 6) using [`Wasmtime`](https://wasmtime.dev/):
```
wasmtime --invoke fibonacci ./target/wasm32-wasi/release/rust_to_wasm.wasm 6
```