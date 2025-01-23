package br.com.alura;

public class Pessoa {

    public Pessoa(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    private Long id;
    private String name;
    private String cpf;

    public Pessoa(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

}
