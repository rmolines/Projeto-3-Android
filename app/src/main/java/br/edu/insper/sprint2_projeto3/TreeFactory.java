package br.edu.insper.sprint2_projeto3;


import java.util.ArrayList;
import java.util.Stack;

public class TreeFactory {
    private static final int NUM_NODES = 40;
    private String[] arvorebinaria = {"NADA","E","T","I","A","N","M","S","U","R",
            "W","D","K","G","O","H","V","F","NADA","L","P","J","B","X",
            "C","Y","Z","Q","NADA","NADA","5","4","3","2","1","6","7",
            "8","9","0"};

    private ArrayList<String> morse = new ArrayList<>();

    private ArrayList<ArrayList<String>> morse_simbolo = new ArrayList<>();


    public TreeFactory() {
        Node[] nodes = new Node[NUM_NODES];
        for(int i = 0; i < NUM_NODES; i++) {
            nodes[i] = new Node(i);
        }


        nodes[0].setLeft(nodes[1]);
        nodes[0].setRight(nodes[2]);
        nodes[1].setLeft(nodes[3]);
        nodes[1].setRight(nodes[4]);
        nodes[2].setLeft(nodes[5]);
        nodes[2].setRight(nodes[6]);
        nodes[3].setLeft(nodes[7]);
        nodes[3].setRight(nodes[8]);
        nodes[4].setLeft(nodes[9]);
        nodes[4].setRight(nodes[10]);
        nodes[5].setLeft(nodes[11]);
        nodes[5].setRight(nodes[12]);
        nodes[6].setLeft(nodes[13]);
        nodes[6].setRight(nodes[14]);
        nodes[7].setLeft(nodes[15]);
        nodes[7].setRight(nodes[16]);
        nodes[8].setLeft(nodes[17]);
        nodes[8].setRight(nodes[18]);
        nodes[9].setLeft(nodes[19]);
        nodes[10].setLeft(nodes[20]);
        nodes[10].setRight(nodes[21]);
        nodes[11].setLeft(nodes[22]);
        nodes[11].setRight(nodes[23]);
        nodes[12].setLeft(nodes[24]);
        nodes[12].setRight(nodes[25]);
        nodes[13].setLeft(nodes[26]);
        nodes[13].setRight(nodes[27]);
        nodes[14].setLeft(nodes[28]);
        nodes[14].setRight(nodes[29]);
        nodes[15].setLeft(nodes[30]);
        nodes[15].setRight(nodes[31]);
        nodes[16].setRight(nodes[32]);
        nodes[18].setRight(nodes[33]);
        nodes[21].setRight(nodes[34]);
        nodes[22].setLeft(nodes[35]);
        nodes[26].setLeft(nodes[36]);
        nodes[28].setLeft(nodes[37]);
        nodes[29].setLeft(nodes[38]);
        nodes[29].setRight(nodes[39]);


        String morsecode = new String();


        Stack<Crumb> stack = new Stack<>();
        stack.push(new Crumb(nodes[0]));


        while(!stack.isEmpty()) {
            Crumb top = stack.peek();
            Node node = top.getNode();

            if(top.getPasses() == 0) {
                //System.out.print(morse);
                String codigo = morsecode;
                morse.add(codigo);
                nodes[node.getValue()].setSimbolo(codigo);
                //System.out.print(top.getNode().getValue());
                //System.out.println(nodes[node.getValue()].getSimbolo());
                //morse_simbolo.add(morse);


                if(node.getLeft() != null) {
                    stack.push(new Crumb(node.getLeft()));
                    morsecode+="o";
                }

                top.incrementPasses();
            }
            else if(top.getPasses() == 1){
                if(node.getRight() != null) {
                    stack.push(new Crumb(node.getRight()));
                    morsecode+="-";
                }

                top.incrementPasses();
            }
            else {

                stack.pop();

                if (morsecode.length()>0){
                    morsecode = morsecode.substring(0,morsecode.length()-1);
                }

                //if (morse.size() != 0){
                //	morse.remove(morse.size()-1);
                //}
            }

        }

    }

    public ArrayList<String> getMorse () {
        return morse;
    }
}
