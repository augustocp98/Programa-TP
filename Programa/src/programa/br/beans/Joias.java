package programa.br.beans;

public class Joias {
	
	public static String escolher(int num){
        switch(num){
        case 1: 
            return "Conjunto";
             
        case 2:
            return "Pulseira Infantil";

        case 3:
            return "Pulseira";

        case 4:
            return "Colar";

        case 5:
            return "Tornozeleira";

        case 6:
            return "Anel";

        case 7:
            return "Brinco";

        default:
            return "Outros";
                 
        }

    }
}
