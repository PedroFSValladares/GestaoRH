package br.edu.infnet.pedrovalladaresapi.loaders;

import org.springframework.boot.ApplicationRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLoader implements ApplicationRunner {
    public List<String> obterLinhasDeArquivo(String nomeDoArquivo, Boolean ignorarCabecalho) throws IOException {
        FileReader arquivo = new FileReader(nomeDoArquivo);
        BufferedReader leitura = new BufferedReader(arquivo);

        List<String> linhas = new ArrayList<>(leitura.lines().toList());
        if (ignorarCabecalho)
            linhas.remove(0);
        arquivo.close();
        return linhas;
    }
}
