import java.util.LinkedList;

public class CodeObjet {
    LinkedList<String> objectCode = new LinkedList<String>();
    ListQuad quads;

    public CodeObjet(ListQuad qd) {
        this.quads = qd;
    }

    private String getBrEquivalent(String branchement) {
        switch (branchement) {
            case "BE":
                return "JE";
            case "BNE":
                return "JNE";
            case "BL":
                return "JL";
            case "BLE":
                return "JLE";
            case "BG":
                return "JG";
            case "BGE":
                return "JGE";
            case "BZ":
                return "JZ";
            case "BNZ":
                return "JNZ";
            case "BR":
                return "JMP";
            default:
                return null;
        }
    }

    private String getOptEquivalent(String operateur) {
        switch (operateur) {
            case "+":
                return "ADD";
            case "-":
                return "SUB";
            case "/":
                return "DIV";
            case "*":
                return "MUL";
            default:
                return null;
        }
    }


    public void transform() {
        int i;
        for (i = 0; i < this.quads.size(); i++) {
            Quad quad = this.quads.getQuad(i);
            String opt = this.getOptEquivalent(quad.getOpt());
            if (opt != null) {
                this.objectCode.add("MOV Ax, " + quad.getOp1());
                this.objectCode.add(opt + " Ax, " + quad.getOp2());
                this.objectCode.add("MOV " + quad.getResult() + ", Ax");
            } else {
                opt = this.getBrEquivalent(this.quads.getQuad(i).getOpt());
                if (opt != null) {
                    if (opt.equals("JZ") || opt.equals("JNZ")) {
                        this.objectCode.add("MOV AX, " + quad.getOp2());
                        this.objectCode.add("CMP AX, 0");
                        //this.objectCode.add(opt + " etiqAdr");
                    } else {
                        if (opt.equals("JMP")) {
                            //this.objectCode.add(opt + " EtiqAdr");
                        } else {
                            this.objectCode.add("MOV AX, " + quad.getOp2());
                            this.objectCode.add("CMP AX, " + quad.getResult());
                            this.objectCode.add(opt + " EtiqeAdr");
                        }
                    }
                } else {
                    opt = quad.getOpt();
                    if (opt.equals("="))
                        this.objectCode.add("Mov " + quad.getResult() + ", " + quad.getOp1());

                    if (opt.equals("READ"))
                        this.objectCode.add("INPUT " + quad.getOp1());

                    if (opt.equals("WRITE"))
                        this.objectCode.add("OUTPUT " + quad.getOp1());
                }
            }
        }
    }

    public void afficherCodeObjet(){
        System.out.println("Code Assembleur");
        System.out.println("----------------");
        for (String s: this.objectCode) {
            System.out.println(s);
        }
    }
}
