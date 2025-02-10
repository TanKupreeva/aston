package org.example.random;

public class Prog{
    FillTheArray fillTheArray;
    String path;

    public void setFillTheArray(FillTheArray fillTheArray) {
        this.fillTheArray = fillTheArray;
    }

    public void fillByRandomVersion1(String path) {
        this.fillTheArray.fillByRandomVersion1(path);
    }

    public void fillByRandomVersion2() {
        this.fillTheArray.fillByRandomVersion2();
    }

    public Object[] fillByFile(String path) {
        return this.fillTheArray.fillByFile(path);

    }

    public void fillByManually() {
        this.fillTheArray.fillByManually();
    }

    public void sortMerge() {

    }

    public void binarySearch() {
    }


}
