package model.entites;

public class Vehicle {
    private String model;

    public Vehicle(){        
    }

    public Vehicle(String model) {
        this.setModel(model);
    }
  
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
