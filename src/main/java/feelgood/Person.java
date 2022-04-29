package feelgood;

public class Person {
    private String name;
    private Summary summary; 

    public Person(String name, Summary summary) throws IllegalArgumentException {
        if (!name.isEmpty() && name.length()<15 && !(name.contains(" "))){ //sjekker at navne er kortere enn 15 bokstaver og ikke inneholder mellomrom 
            this.name = name; 
        }
        else{
            throw new IllegalArgumentException("Du kan ikke bruke mellomrom i brukernavnet. Det kan heller ikke bestå av mer enn 15 bokstaver.");
        }
        this.summary = summary;
    }

    public String getName(){
        return this.name; 
    }

    public Summary getSummary(){
        return this.summary;
    }

    
}