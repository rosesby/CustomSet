package com.mcc;

import javafx.util.Pair;

public class CustomPair<K,V> extends Pair<K,V>{

    public CustomPair(K key, V value) {
        super(key, value);
    }

    @Override
    public String toString() {
        return "(" + this.getKey() + " , " + this.getValue() + ")";
    }
}
