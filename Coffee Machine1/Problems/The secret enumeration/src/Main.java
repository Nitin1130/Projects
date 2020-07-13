public class Main {

    public static void main(String[] args) {
        Secret[] s = Secret.values();
        int count = 0;
        for(Secret n: Secret.values()){
            String a = s.toString();
            if(a.startsWith("STAR") == true){
                count++;
                System.out.println(count);
            }

            
        }


    }
}

/*
enum Secret {
    STAR, CRASH, START, // ...
}
*/