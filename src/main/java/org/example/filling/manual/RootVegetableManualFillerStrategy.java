package org.example.filling.manual;

import org.example.entity.RootVegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RootVegetableManualFillerStrategy extends ManualFillerStrategy<RootVegetable> {
    public RootVegetableManualFillerStrategy(List<RootVegetable> list) {
        super(list);
    }

    @Override
    protected RootVegetable getV() {
        String type = "";
        double weight = 0;
        String color = "";
        boolean is = true;
        while (is) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
                System.out.println("Enter type:\n");
                type = bufferedReader.readLine();
                System.out.println("Enter weight:\n");
                weight = Double.parseDouble(bufferedReader.readLine());
                System.out.println("Enter color:\n");
                color = bufferedReader.readLine();
                is = false;
            } catch (NumberFormatException ex) {
                System.out.println("This field only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        }
        RootVegetable rootVegetable = RootVegetable.builder()
                .type(type)
                .weight(weight)
                .color(color)
                .build();
        return rootVegetable;
    }
}
