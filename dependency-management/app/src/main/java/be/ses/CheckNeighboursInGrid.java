package be.ses;

import java.util.ArrayList;


public class CheckNeighboursInGrid {
/**
* This method takes a 1D Iterable and an element in the array and gives back an iterable containing the indexes of all neighbours with the same value as the specified element
*@return - Returns a 1D Iterable of ints, the Integers represent the indexes of all neighbours with the same value as the specified element on index 'indexToCheck'.
*@param grid - This is a 1D Iterable containing all elements of the grid. The elements are integers.
*@param width - Specifies the width of the grid.
*@param height - Specifies the height of the grid (extra for checking if 1D grid is complete given the specified width)
*@param indexToCheck - Specifies the index of the element which neighbours that need to be checked
*/
public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid, int width, int height, int indexToCheck) {
    ArrayList<Integer> result = new ArrayList<>();
    ArrayList<Integer> gridList = new ArrayList<>();

    for (Integer value : grid) {
        gridList.add(value);
    }
    
    if (indexToCheck >= height * width || indexToCheck < 0) {
        throw new ArithmeticException("Fout: Index " + indexToCheck + " ligt buiten de geldige grenzen (0 - " + (width * height - 1) + ")");
    }
    
    int waarde = gridList.get(indexToCheck);
    
    // Controleer linksboven buur
    if (indexToCheck >= width && indexToCheck % width > 0) {
        if (gridList.get(indexToCheck - width - 1) == waarde) {
            result.add(indexToCheck - width - 1);
        }
    }

    // Controleer boven buur
    if (indexToCheck >= width) {
        if (gridList.get(indexToCheck - width) == waarde) {
            result.add(indexToCheck - width);
        }
    }

    // Controleer rechtsboven buur
    if (indexToCheck >= width && (indexToCheck + 1) % width != 0) {
        if (gridList.get(indexToCheck - width + 1) == waarde) {
            result.add(indexToCheck - width + 1);
        }
    }

    // Controleer linker buur
    if (indexToCheck % width > 0) {
        if (gridList.get(indexToCheck - 1) == waarde) {
            result.add(indexToCheck - 1);
        }
    }
    
    // Controleer rechter buur
    if ((indexToCheck + 1) % width != 0) { 
        if (gridList.get(indexToCheck + 1) == waarde) {
            result.add(indexToCheck + 1);
        }
    }

    // Controleer linksonder buur
    if (indexToCheck < (height - 1) * width && indexToCheck % width > 0) {
        if (gridList.get(indexToCheck + width - 1) == waarde) {
            result.add(indexToCheck + width - 1);
        }
    }
    
    // Controleer onder buur
    if (indexToCheck < (height - 1) * width) {
        if (gridList.get(indexToCheck + width) == waarde) {
            result.add(indexToCheck + width);
        }
    }
        
    // Controleer rechtsonder buur
    if (indexToCheck < (height - 1) * width && (indexToCheck + 1) % width != 0) {
        if (gridList.get(indexToCheck + width + 1) == waarde) {
            result.add(indexToCheck + width + 1);
        }
    }
    
    return result;
}
}
