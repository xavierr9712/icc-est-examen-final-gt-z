package models;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class Maquina implements Comparable<Maquina> {

    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred; 
    private int riesgo; 

    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
        calcularSubred();
        calcularRiesgo();
    }

    
    public String getNombre() {
        return nombre;
    }

    public String getIp() {
        return ip;
    }

    public List<Integer> getCodigos() {
        return codigos;
    }

    public int getSubred() {
        return subred;
    }

    public int getRiesgo() {
        return riesgo;
    }

    
    private void calcularSubred() {
        String[] ipParts = this.ip.split("\\.");
        if (ipParts.length == 4) {
            this.subred = Integer.parseInt(ipParts[3]); 
        } else {
            this.subred = 0; 
        }
    }

    private void calcularRiesgo() {
        int sumDivisibleBy3 = 0;
        for (int codigo : codigos) {
            if (codigo % 3 == 0) {
                sumDivisibleBy3 += codigo;
            }
        }

        Set<Character> uniqueChars = new HashSet<>();
        for (char c : nombre.replace(" ", "").toCharArray()) { 
            uniqueChars.add(c);
        }
        this.riesgo = sumDivisibleBy3 * uniqueChars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maquina maquina = (Maquina) o;
        return subred == maquina.subred && Objects.equals(nombre, maquina.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, subred);
    }

    @Override
    public int compareTo(Maquina other) {
        int subredComparison = Integer.compare(this.subred, other.subred);
        if (subredComparison != 0) {
            return subredComparison;
        }
        return this.nombre.compareTo(other.nombre);
    }

    @Override
    public String toString() {
        return "" +
               " " + nombre + '\'' +
               " " + ip + '\'' +
               "" + subred +
               "" + riesgo +
               '}';
    }
}

    


    

