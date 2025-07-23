
package controllers;

import models.Maquina;

import java.util.*;

public class MaquinaController {

 
    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas, int umbral) {
        Stack<Maquina> filteredMaquinas = new Stack<>();
        for (Maquina maquina : maquinas) {
            if (maquina.getSubred() < umbral) {
                filteredMaquinas.push(maquina);
            }
        }
        return filteredMaquinas;
    }

   
    public TreeSet<Maquina> ordenarPorSubred(Stack<Maquina> pila) {
        TreeSet<Maquina> sortedMaquinas = new TreeSet<>();
      
        List<Maquina> tempList = new ArrayList<>();
        while (!pila.isEmpty()) {
            tempList.add(pila.pop());
        }
      
        sortedMaquinas.addAll(tempList);
        return sortedMaquinas;
    }


    public TreeMap<Integer, Queue<Maquina>> agruparPorRiesgo(List<Maquina> maquinas) {
        TreeMap<Integer, Queue<Maquina>> groupedByRiesgo = new TreeMap<>();
        for (Maquina maquina : maquinas) {
            int riesgo = maquina.getRiesgo();
            groupedByRiesgo.computeIfAbsent(riesgo, k -> new LinkedList<>()).offer(maquina);
        }
        return groupedByRiesgo;
    }


    public Stack<Maquina> explotarGrupo(Map<Integer, Queue<Maquina>> mapa) {
        int maxMachines = -1;
        int maxRiesgo = -1;
        Queue<Maquina> targetQueue = null;

        for (Map.Entry<Integer, Queue<Maquina>> entry : mapa.entrySet()) {
            int currentRiesgo = entry.getKey();
            Queue<Maquina> currentQueue = entry.getValue();

            if (currentQueue.size() > maxMachines) {
                maxMachines = currentQueue.size();
                maxRiesgo = currentRiesgo;
                targetQueue = currentQueue;
            } else if (currentQueue.size() == maxMachines) {
                if (currentRiesgo > maxRiesgo) {
                    maxRiesgo = currentRiesgo;
                    targetQueue = currentQueue;
                }
            }
        }

        Stack<Maquina> resultStack = new Stack<>();
        if (targetQueue != null) {
        
            List<Maquina> tempMachines = new ArrayList<>();
            while (!targetQueue.isEmpty()) {
                tempMachines.add(targetQueue.poll());
            }
            for (int i = tempMachines.size() - 1; i >= 0; i--) {
                resultStack.push(tempMachines.get(i));
            }
        }
        return resultStack;
    }
}