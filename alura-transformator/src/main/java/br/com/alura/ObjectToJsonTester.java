package br.com.alura;

public class ObjectToJsonTester {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1L,"Joao","123456");
        ObjectToJson objectToJson = new ObjectToJson();
        System.out.println(objectToJson.transform(pessoa));
    }
}
