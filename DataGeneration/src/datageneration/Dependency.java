/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datageneration;

/**
 *
 * @author Rehan
 */
public class Dependency {
    private String dependant;
    private String dependentOn;
    private Dependency feature1;
    private Dependency feature2;
    private Dependency feature3;
    private Dependency feature4;

    public Dependency getFeature1() {
        return feature1;
    }

    public void setFeature1(Dependency feature1) {
        this.feature1 = feature1;
    }

    public Dependency getFeature2() {
        return feature2;
    }

    public void setFeature2(Dependency feature2) {
        this.feature2 = feature2;
    }

    public Dependency getFeature3() {
        return feature3;
    }

    public void setFeature3(Dependency feature3) {
        this.feature3 = feature3;
    }

    public Dependency getFeature4() {
        return feature4;
    }

    public void setFeature4(Dependency feature4) {
        this.feature4 = feature4;
    }

    public String getDependant() {
        return dependant;
    }

    public void setDependant(String dependant) {
        this.dependant = dependant;
    }

    public String getDependentOn() {
        return dependentOn;
    }

    public void setDependentOn(String dependentOn) {
        this.dependentOn = dependentOn;
    }
    
    public String getFeatureValue() {
        //return "" + Integer.parseInt(dependentOn, 16) + ", " + Integer.parseInt(dependant, 16);
        return "" + Integer.parseInt(dependentOn, 16)%100000 + ", " + Integer.parseInt(dependant, 16)%100000;
    }
}
