package feelgood;

public class Person {
    private String name;

    //*** når vi kjører appen og skriver inn navn blir det gjort om til feelgood.person.... 
    //  feilsøking og det er noe enten i person klassen eller når vi henter inn navnet i controlleren*/

    public Person(String name){

        if (name.length()<15 && !(name.contains(" "))){ //sjekker at navne er kortere enn 15 bokstaver og ikke inneholder mellomrom 
            this.name = name; 
        }
        else{
            throw new IllegalArgumentException("Brukernavnet kan kun bestå av ett ord. Det kan heller ikke være lengere enn 15 bokstaver.");
        }
        
    }

public String getName(){
    return this.name; 
}
}