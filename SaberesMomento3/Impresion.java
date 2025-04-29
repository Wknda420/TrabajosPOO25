package SaberesMomento3;

public class Impresion extends Foto { /*impresion representa una foto que
    se heredo de la clase foto */
    private String color;
    private Foto foto; //composicion

    public Impresion(String color, Foto foto){
        super(foto.getFichero());/*el super llama al constructor foto que recibe 
        un string y usa ese valor para iniciar el atributo en la clase foto. 
        En esa clase solo hay un constructor con ciertos parametros
        por eso es obligatorio usar el (super)*/

        this.color = color;
        this.foto = foto;
    }

    /*se usa un override pq se esta sobreescribiendo el metodo print de 
    la clase foto o sea al llamar pirnti en impresion se iniciara esta
    version en vez de la de la clase foto*/
    
    @Override
    public void print() { 
        System.out.println("Impresion a color " + color + " de: " + getFichero());
    }

}
