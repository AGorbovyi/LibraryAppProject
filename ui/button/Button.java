package main.java.libraryapp.ui.button;

public abstract class Button {
    private List<Service> services;
    Button(List<Service> services) {
        this.services = services;
    }
    public getServices(){
        return services;
    }
    public getService(String name){
        for(Service service : services){
            if (service.getName().equals(name)){
                return service;
            }
        }
    }
}
