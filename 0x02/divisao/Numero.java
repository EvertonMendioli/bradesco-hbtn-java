public class Numero {

    public static void dividir(int a, int b){
        int result = 0;
        String texto = "";
        try {
            result = a/b;
            texto = String.valueOf(a) + " / " + String.valueOf(b) + " = " + result;   
            
        } catch (Exception e) {
            
            texto = "Nao eh possivel dividir por zero\n";
            texto += String.valueOf(a) + " / " + String.valueOf(b) + " = 0";
        } finally
        {
            System.out.println(texto);
        }
    }
}
