package org.example.services;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FileHandlerServiceTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    private File file;

    @Before
    public void setUp() throws IOException {
        // Cria um arquivo dentro da pasta temporária
        file = temporaryFolder.newFile("dados.txt");
    }

    @Test
    public void testeReadDataDataLineByLine() throws IOException {
        // Escreve algumas linhas no arquivo
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("linha 1");
        bufferedWriter.newLine();
        bufferedWriter.write("linha 2");
        bufferedWriter.newLine();
        bufferedWriter.write("linha 3");
        bufferedWriter.close();

        // Lê os dados do arquivo usando o FileHandlerService
        ArrayList<String> linhas = FileHandlerService.readDataDataLineByLine(file.getAbsolutePath());

        // Verifica se as linhas foram lidas corretamente
        assertEquals(3, linhas.size());
        assertEquals("linha 1", linhas.get(0));
        assertEquals("linha 2", linhas.get(1));
        assertEquals("linha 3", linhas.get(2));
    }

    @Test
    public void testeWriteDataLineByLine() throws IOException {
        // Cria uma lista de strings com alguns dados
        ArrayList<String> dados = new ArrayList<>();
        dados.add("linha 1");
        dados.add("linha 2");
        dados.add("linha 3");

        // Escreve os dados no arquivo usando o FileHandlerService
        FileHandlerService.writeDataLineByLine(file.getAbsolutePath(), dados);

        // Lê os dados do arquivo
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        ArrayList<String> linhasLidas = new ArrayList<>();
        String linha = bufferedReader.readLine();
        while (linha != null) {
            linhasLidas.add(linha);
            linha = bufferedReader.readLine();
        }
        bufferedReader.close();

        // Verifica se as linhas foram escritas corretamente no arquivo
        assertEquals(3, linhasLidas.size());
        assertEquals("linha 1", linhasLidas.get(0));
        assertEquals("linha 2", linhasLidas.get(1));
        assertEquals("linha 3", linhasLidas.get(2));
    }
}
