/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datageneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rehan
 */
public class ParseDepGenWekaIn {

    ArrayList<Dependency> depList = new ArrayList<>();

    public static void main(String[] args) {
        ParseDepGenWekaIn depGenWekaIn = new ParseDepGenWekaIn();
        depGenWekaIn.readDep("dependencyData\\new_2_list_thread.1");
//        depGenWekaIn.generateWekaInput("dependencyData\\list_thread.0");
        depGenWekaIn.generateWekaInput("dependencyData\\new_2_list_thread.1");
    }

    private void generateWekaInput(String outFileName) {
        FileWriter fw = null;
        try {
            outFileName = outFileName + ".arff";
            fw = new FileWriter(outFileName);

            fw.write("@relation experiment\n\n");
            //fw.write("@attribute depStr string\n");
            for (int i = 0; i < 10; i++) {
                fw.write("@attribute " + "dep_" + (i + 1) + " real\n");
            }

            fw.write("@attribute class {n,p}\n");
            fw.write("\n@data\n");

            Iterator<Dependency> itr = depList.iterator();
            while (itr.hasNext()) {
                Dependency d = itr.next();
                writeTuple(fw, d, d.getDependentOn(), d.getDependant(), "p");
                writeTuple(fw, d, d.getDependant(), d.getDependentOn(), "n");
                
//                writeTestTuple(fw, d, d.getDependentOn(), d.getDependant());
            }

        } catch (IOException ex) {
            Logger.getLogger(ParseDepGenWekaIn.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(ParseDepGenWekaIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void generateWekaStringInput(String outFileName) {
        FileWriter fw = null;
        try {
            outFileName = outFileName + ".arff";
            fw = new FileWriter(outFileName);

            fw.write("@relation experiment\n\n");
            fw.write("@attribute depStr string\n");
            for (int i = 0; i < 4; i++) {
                fw.write("@attribute " + "dep_" + (i + 1) + " string\n");
            }

            fw.write("@attribute class {n,p}\n");
            fw.write("\n@data\n");

            Iterator<Dependency> itr = depList.iterator();
            while (itr.hasNext()) {
                Dependency d = itr.next();
                writeStringTuple(fw, d, d.getDependentOn(), d.getDependant(), "p");
                writeStringTuple(fw, d, d.getDependant(), d.getDependentOn(), "n");
            }

        } catch (IOException ex) {
            Logger.getLogger(ParseDepGenWekaIn.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(ParseDepGenWekaIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void writeStringTuple(FileWriter fw, Dependency d, String dependentOn, String dependant, String tupleClass) throws IOException {
        fw.write(dependentOn + "<-" + dependant + ", ");
        if (d.getFeature1() != null) {
            fw.write(d.getFeature1().getDependentOn() + "#" + d.getFeature1().getDependant() + ", ");
        } else {
            fw.write("null#null, ");
        }
        if (d.getFeature2() != null) {
            fw.write(d.getFeature2().getDependentOn() + "#" + d.getFeature2().getDependant() + ", ");
        } else {
            fw.write("null#null, ");
        }
        if (d.getFeature3() != null) {
            fw.write(d.getFeature3().getDependentOn() + "#" + d.getFeature3().getDependant() + ", ");
        } else {
            fw.write("null#null, ");
        }
        if (d.getFeature4() != null) {
            fw.write(d.getFeature4().getDependentOn() + "#" + d.getFeature4().getDependant() + ", ");
        } else {
            fw.write("null#null, ");
        }
        fw.write(tupleClass + "\n");

    }
    
    private void writeTuple(FileWriter fw, Dependency d, String dependentOn, String dependant, String tupleClass) throws IOException {
        //fw.write(dependentOn + "<-" + dependant + ", ");
        fw.write(Integer.parseInt(dependentOn, 16)%100000 + ", " + Integer.parseInt(dependant, 16)%100000 + ", ");
        //fw.write(d.getFeatureValue() + ", "); --> wrong
        if (d.getFeature1() != null) {
            fw.write( d.getFeature1().getFeatureValue() + ", ");
        } else {
            fw.write("0, 0, ");
        }
        if (d.getFeature2() != null) {
            fw.write(d.getFeature2().getFeatureValue() + ", ");
        } else {
            fw.write("0, 0, ");
        }
        if (d.getFeature3() != null) {
            fw.write(d.getFeature3().getFeatureValue() + ", ");
        } else {
            fw.write("0, 0, ");
        }
        if (d.getFeature4() != null) {
            fw.write(d.getFeature4().getFeatureValue() + ", ");
        } else {
            fw.write("0, 0, ");
        }
        fw.write(tupleClass + "\n");
    }
    
    private void writeTestTuple(FileWriter fw, Dependency d, String dependentOn, String dependant) throws IOException {
        //fw.write(dependentOn + "<-" + dependant + ", ");
        fw.write(Integer.parseInt(dependentOn, 16)%100000 + ", " + Integer.parseInt(dependant, 16)%100000 + ", ");
        //fw.write(d.getFeatureValue() + ", "); --> wrong
        if (d.getFeature1() != null) {
            fw.write( d.getFeature1().getFeatureValue() + ", ");
        } else {
            fw.write("0, 0, ");
        }
        if (d.getFeature2() != null) {
            fw.write(d.getFeature2().getFeatureValue() + ", ");
        } else {
            fw.write("0, 0, ");
        }
        if (d.getFeature3() != null) {
            fw.write(d.getFeature3().getFeatureValue() + ", ");
        } else {
            fw.write("0, 0, ");
        }
        if (d.getFeature4() != null) {
            fw.write(d.getFeature4().getFeatureValue());
        } else {
            fw.write("0, 0");
        }
        //fw.write(tupleClass + "\n");
        fw.write("\n");
    }


    private void readDep(String fileName) {
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);

            Dependency feature1 = null;
            Dependency feature2 = null;
            Dependency feature3 = null;
            Dependency feature4 = null;
            Dependency d = null;

            while (s.hasNext()) {
                String line = s.nextLine();
                String temp[] = line.split("<-");
                d = new Dependency();

                d.setDependant(temp[1]);
                d.setDependentOn(temp[0]);

                d.setFeature1(feature1);
                d.setFeature2(feature2);
                d.setFeature3(feature3);
                d.setFeature4(feature4);

                depList.add(d);

                feature1 = feature2;
                feature2 = feature3;
                feature3 = feature4;
                feature4 = d;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParseDepGenWekaIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
