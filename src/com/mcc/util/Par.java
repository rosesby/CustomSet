package com.mcc.util;

import javafx.util.Pair;

public class Par<K,V> extends Pair<K,V>{

    public Par(K key, V value) {
        super(key, value);
    }

    @Override
    public String toString() {
        return "(" + this.getKey() + " , " + this.getValue() + ")";
    }
}
