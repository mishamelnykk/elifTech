package restTask;

public class Main {
    public static void main(String[] args) throws Exception {
        String result = "";

        HttpURLConnectionTest con = new HttpURLConnectionTest();
        PolishPostfixNotation notation = new PolishPostfixNotation();
        con.sendGet();

        String[] masStr = con.getInputLine().split("[\\,,\\[,\\]]");
        String id = masStr[masStr.length-1].substring(5, masStr[masStr.length-1].length()-1);
//        System.out.println(masStr[masStr.length-1]);

        for(int i = 1; i < masStr.length-2; i++) {
            masStr[i] = masStr[i].substring(1, masStr[i].length()-1);
            String[] masStrSym = masStr[i].split(" ");
            boolean status = true;

            for (int j = 0; j < masStrSym.length; j++){

                if (status == true) {
                    switch (masStrSym[j + 1]) {

                        case "+": {
                            masStrSym[j - 1] = notation.sum(Integer.parseInt(masStrSym[j - 1]), Integer.parseInt(masStrSym[j])) + "";
                            masStrSym[j] = masStrSym[j+2];
                            masStrSym[j + 1] = null;
                            masStrSym[j+2] = null;
                            status = false;
                            break;
                        }
                        case "-": {
                            masStrSym[j - 1] = notation.sub(Integer.parseInt(masStrSym[j - 1]), Integer.parseInt(masStrSym[j])) + "";
                            masStrSym[j] = masStrSym[j+2];
                            masStrSym[j + 1] = null;
                            masStrSym[j+2] = null;
                            status = false;
                            break;
                        }
                        case "*": {
                            masStrSym[j - 1] = notation.mul(Integer.parseInt(masStrSym[j - 1]), Integer.parseInt(masStrSym[j])) + "";
                            masStrSym[j] = masStrSym[j+2];
                            masStrSym[j + 1] = null;
                            masStrSym[j+2] = null;
                            status = false;
                            break;
                        }
                        case "/": {
                            masStrSym[j - 1] = notation.div(Integer.parseInt(masStrSym[j - 1]), Integer.parseInt(masStrSym[j])) + "";
                            masStrSym[j] = masStrSym[j+2];
                            masStrSym[j + 1] = null;
                            masStrSym[j+2] = null;
                            status = false;
                            break;

                        }
                    }

                } else {
//                    System.out.println(j);
//                    System.out.println(masStrSym.length);
//                    System.out.println(j+2);
                    masStrSym[j] = masStrSym[j+2];
                    masStrSym[j+2] = null;
                }
                if ((j+3) == masStrSym.length){
                    j = 0;
                    status = true;
                }
                if (masStrSym[1]==null){
                    result += masStrSym[0] + ", ";
                    break;
                }
            }
        }
        System.out.println(result);
//        String urlID = "{\"results\":["+result.substring(0,result.length()-2)+"],"+masStr[masStr.length-1];
//        String urlID = "{\"id\":"+id+",\"results\":["+result.substring(0,result.length()-2)+ "]}";
        String urlID = "{\"results\":["+result.substring(0,result.length()-2)+ "], \"id\":" + id + "}";
//        String urlID = "{" + masStr[masStr.length-1].substring(0,masStr[masStr.length-1].length()-1) + ",\"results\":["+result.substring(0,result.length()-2)+"]}";
//        String urlID = masStr[masStr.length-1].substring(5,masStr[masStr.length-1].length()-2);;
        System.out.println(urlID);
        con.sendPost(urlID);

    }
}
