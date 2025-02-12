package org.example.soututils;

import org.example.entity.RootVegetable;

import java.io.BufferedReader;
import java.io.IOException;

public class GetValueRootVegetable extends GetValue<RootVegetable>{

    public GetValueRootVegetable(BufferedReader bufferedReader) {
        super(bufferedReader, null);
        function = this::getValue;
    }

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
                        (i != -1 ? "Try filling object number " + i + " again." : "Try again."));
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
