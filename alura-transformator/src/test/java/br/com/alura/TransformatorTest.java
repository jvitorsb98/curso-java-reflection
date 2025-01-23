package br.com.alura;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class TransformatorTest {

    Pessoa pessoa = new Pessoa(1L,"João","1234");
    Endereco endereco = new Endereco("Rua A" , 20);

    @Test
    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class,pessoaDTO);
        Assertions.assertEquals(pessoa.getName(),pessoaDTO.getName());
        Assertions.assertEquals(pessoa.getCpf(),pessoaDTO.getCpf());
    }

    @Test
    public void shouldNotTransform() {
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            Transformator transformator = new Transformator();
            transformator.transform(endereco);
        });
    }

    @Test
    public void shouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoaSemCPF = new Pessoa("João");
        Transformator transformator= new Transformator();
        PessoaDTO pessoaDTOSemCPF = transformator.transform(pessoaSemCPF);
        Assertions.assertEquals(pessoa.getName(),pessoaDTOSemCPF.getName());
        Assertions.assertNull(pessoaDTOSemCPF.getCpf());
    }

}
