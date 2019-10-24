package com.android.support.utils.dex.item;

public class ClassDefItem {
    public static final int ACC_ABSTRACT = 1024;
    public static final int ACC_ANNOTATION = 8192;
    public static final int ACC_BRIDGE = 64;
    public static final int ACC_CLASS_MASK = 30225;
    public static final int ACC_CONSTRUCTOR = 65536;
    public static final int ACC_DECLARED_SYNCHRONIZED = 131072;
    public static final int ACC_ENUM = 16384;
    public static final int ACC_FIELD_MASK = 20703;
    public static final int ACC_FINAL = 16;
    public static final int ACC_INNER_CLASS_MASK = 30239;
    public static final int ACC_INTERFACE = 512;
    public static final int ACC_METHOD_MASK = 204287;
    public static final int ACC_NATIVE = 256;
    public static final int ACC_PRIVATE = 2;
    public static final int ACC_PROTECTED = 4;
    public static final int ACC_PUBLIC = 1;
    public static final int ACC_STATIC = 8;
    public static final int ACC_STRICT = 2048;
    public static final int ACC_SUPER = 32;
    public static final int ACC_SYNCHRONIZED = 32;
    public static final int ACC_SYNTHETIC = 4096;
    public static final int ACC_TRANSIENT = 128;
    public static final int ACC_VARARGS = 128;
    public static final int ACC_VOLATILE = 64;
    public int access_flags;
    public int annotations_off;
    public int class_data_off;
    public int class_idx;
    public int iterfaces_off;
    public int source_file_idx;
    public int static_value_off;
    public int superclass_idx;

    public static int getSize() {
        return 32;
    }
}