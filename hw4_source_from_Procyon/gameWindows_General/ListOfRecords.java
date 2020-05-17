// 
// Decompiled by Procyon v0.5.36
// 

package gameWindows_General;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class ListOfRecords
{
    int[] records;
    
    public ListOfRecords() {
        (this.records = new int[4])[0] = 0;
        this.records[1] = 0;
        this.records[2] = 0;
        this.records[3] = 0;
    }
    
    public void saveToFile(final String fileName) throws IOException {
        final File f = new File(fileName);
        final FileWriter fw = new FileWriter(f);
        for (int i = 0; i < 4; ++i) {
            final String s = this.records[i] + "\n";
            fw.write(s);
        }
        fw.close();
    }
    
    public void loadFromFile(final String fileName) throws FileNotFoundException {
        final File f = new File(fileName);
        final Scanner fileInput = new Scanner(f);
        for (int i = 0; i < 4; ++i) {
            if (fileInput.hasNextLine()) {
                final String line = fileInput.nextLine();
                this.records[i] = Integer.parseInt(line);
            }
        }
        fileInput.close();
    }
    
    public int[] getRecords() {
        return this.records;
    }
}
