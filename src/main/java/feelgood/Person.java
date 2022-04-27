package feelgood;

public class Person {
    private String name;
    private Summary summary; // 

    //*** når vi kjører appen og skriver inn navn blir det gjort om til feelgood.person.... 
    //  feilsøking og det er noe enten i person klassen eller når vi henter inn navnet i controlleren*/

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

    //setter personens summary som oppdatert summary ()
    public void setSummary(Summary newSummary){
        this.summary=newSummary;
    }
}