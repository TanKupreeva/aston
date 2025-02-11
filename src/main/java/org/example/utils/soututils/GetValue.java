package org.example.utils.soututils;

import java.io.BufferedReader;
import java.util.function.IntFunction;

public class GetValue<T> {

    BufferedReader bufferedReader;

    IntFunction<T> function;

    public GetValue(BufferedReader bufferedReader, IntFunction<T> function) {
        this.bufferedReader = bufferedReader;
        this.function = function;
    }

    public IntFunction<T> getFunction() {
        return function;
    }
}
