package feelgood;

public class Person {
    private String name; 

    public Person(String name){

        if (name.equals("") || name.length()<15 && !(name.contains(" "))){ //sjekker at navne er kortere enn 15 bokstaver og ikke inneholder mellomrom 
            this.name = name; 
        }
        else{
            throw new IllegalArgumentException("Brukernavnet kan kun bestå av ett ord. Det kan heller ikke være lengere enn 15 bokstaver.");
        }
        
    }

/*
public void setName(String name) {
        // hvis valideringen til navn ikke stemmer
        if (! validateName(name)) {
            throw new IllegalArgumentException("Illegal name"); 
        }

        this.name = name; 
}
*/

/*if (brukernavn.getText().equals("")){
            throw new IllegalArgumentException("Du må skrive inn et brukernavn.");
        }*/

public String getName(){
    return name; 
}


}