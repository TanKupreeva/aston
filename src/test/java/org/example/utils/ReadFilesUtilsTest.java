package org.example.utils;

import org.junit.jupiter.api.Test;

public class ReadFilesUtilsTest {

    @Test
    public void testReadFiles() {
        System.out.println(ReadFilesUtils.getBooksFromFile());
        System.out.println(ReadFilesUtils.getCarsFromFile());
        System.out.println(ReadFilesUtils.getRootVegetablesFromFile());

        System.out.println();

        System.out.println(ReadFilesUtils.getListFromFile(Type.BOOK));
    }
}
