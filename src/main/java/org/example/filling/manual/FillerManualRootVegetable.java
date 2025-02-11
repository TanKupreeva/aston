package org.example.filling.manual;

import org.example.entity.RootVegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class FillerManualRootVegetable extends FillerManual<RootVegetable> {
    public FillerManualRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
        super(bufferedReader, list);
    }

    @Override
    protected RootVegetable getValue(int i) {
        String type = "";
        double weight = 0;
        String color = "";
        boolean is = true;
        while (is) {
            try {
                System.out.println("Enter type:");
                type = bufferedReader.readLine();
                System.out.println("Enter weight:");
                weight = Double.parseDouble(bufferedReader.readLine());
                System.out.println("Enter color:");
                color = bufferedReader.readLine();
                is = false;
            } catch (NumberFormatException ex) {
                System.out.print("This field only accepts numbers.\n\n" +
                        "Try filling object number " + i + " again.");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        RootVegetable rootVegetable = RootVegetable.builder()
                .type(type)
                .weight(weight)
                .color(color)
                .build();
        return rootVegetable;
    }

}
