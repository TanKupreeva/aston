package random;

public class Prog {
    FillTheArray fillTheArray;
    String path;

    public void setFillTheArray(FillTheArray fillTheArray) {
        this.fillTheArray = fillTheArray;
    }

    public void fillByRandom() {
        this.fillTheArray.fillByRandom(path);
    }

    public void fillByFile() {
        this.fillTheArray.fillByFile(path);
    }

    public void fillByManually() {
        this.fillTheArray.fillByManually();
    }

    public void sortMerge() {

    }

    public void binarySearch() {
    }


}
