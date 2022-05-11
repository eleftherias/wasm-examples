package fibonacci;

import static io.github.kawamuray.wasmtime.WasmValType.I32;
import static java.util.Collections.emptyList;

import io.github.kawamuray.wasmtime.Func;
import io.github.kawamuray.wasmtime.Instance;
import io.github.kawamuray.wasmtime.Module;
import io.github.kawamuray.wasmtime.Store;
import io.github.kawamuray.wasmtime.WasmFunctions;

public class WasmFibonacci {
  public static void main(String[] args) {
    try (Store<Void> store = Store.withoutData();
        Module module = Module.fromFile(store.engine(), "./fibonacci.wasm");
        Instance instance = new Instance(store, module, emptyList());
        Func addFunction = instance.getFunc(store, "fibonacci").get()) {
      WasmFunctions.Function1<Integer, Integer> add = WasmFunctions.func(
          store, addFunction, I32, I32);
      System.out.println("Calling fibonacci function on 8:");
      System.err.println("result = " + add.call(8));
      System.err.println("Done.");
    }
  }
}
