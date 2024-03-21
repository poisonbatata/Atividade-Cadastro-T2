package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import Models.Evento;
import Models.Pessoa;
import Models.Associacao;

public class BD {
    String path;

    public BD(String path) {
        this.path = path;
    }

    public void salvar(Object obj) {
        BufferedWriter arq;
        try {
            if (obj instanceof Pessoa) {
                arq = new BufferedWriter(new FileWriter(path + "pessoa.txt", true));
                arq.write(((Pessoa) obj).getCPF() + "|" + ((Pessoa) obj).getNome() + "|" + ((Pessoa) obj).getEmail());
                arq.newLine();
                arq.close();
            }
            if (obj instanceof Evento) {
                arq = new BufferedWriter(new FileWriter(path + "evento.txt", true));
                arq.write(((Evento) obj).getNome() + "|" + ((Evento) obj).getTipo() + "|" + ((Evento) obj).getLocal()
                        + "|" + "\n");
                arq.close();
            }
            if (obj instanceof Associacao) {
                arq = new BufferedWriter(new FileWriter(path + "pessoa_evento.txt", true));
                arq.write(((Associacao) obj).getCPF() + "|" + ((Associacao) obj).getEvento() + "\n");
                arq.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[] obterLista(String tipo) {
        Object[] lista = new Object[1000];
        int cont = 0;
        BufferedReader arq;
        String linha;
        StringTokenizer tokens;
        try {
            if (tipo.equals("Pessoa")) {
                arq = new BufferedReader(new FileReader(path + "pessoa.txt"));
                while (arq.ready()) {
                    linha = arq.readLine();
                    tokens = new StringTokenizer(linha, "|");
                    String cp = tokens.nextToken();
                    String np = tokens.nextToken();
                    String ep = tokens.nextToken();
                    Pessoa p = new Pessoa(np, cp, ep);
                    lista[cont] = p;
                    cont++;
                }
                arq.close();
            }
            if (tipo.equals("Evento")) {
                arq = new BufferedReader(new FileReader(path + "evento.txt"));
                while (arq.ready()) {
                    linha = arq.readLine();
                    tokens = new StringTokenizer(linha, "|");
                    String na = tokens.nextToken();
                    String ta = tokens.nextToken();
                    String la = tokens.nextToken();
                    String IDa = tokens.nextToken();
                    Evento a = new Evento(na, ta, la);
                    lista[cont] = a;
                    cont++;
                }
                arq.close();
            }
            if (tipo.equals("Associacao")) {
                arq = new BufferedReader(new FileReader(path + "pessoa_evento.txt"));
                while (arq.ready()) {
                    linha = arq.readLine();
                    tokens = new StringTokenizer(linha, "|");
                    String np = tokens.nextToken();
                    String na = tokens.nextToken();
                    Associacao pa = new Associacao(np, na);
                    lista[cont] = pa;
                    cont++;
                }
                arq.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public int obterTamanho(String tipo) {
        int i = 0;
        Object[] lista = obterLista(tipo);
        for (i = 0; i < lista.length; i++)
            try {
                String s = lista[i].toString();
            } catch (NullPointerException e) {
                break;
            }
        return i;
    }
}