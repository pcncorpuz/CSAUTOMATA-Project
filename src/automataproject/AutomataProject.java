package automataproject;
import java.util.Scanner;

public class AutomataProject {
   
    public static void main(String[] args) {
        
/*                        1st part                                            */
        Scanner s = new Scanner(System.in);                                     // scanners
        Scanner l = new Scanner(System.in);                                     // nag kaka problema pag ginamit mo yung int scanner tapos line scanner kaya dalawa
        System.out.print("Enter number of symbols: ");
        int symbol = s.nextInt();
        for(int i = 0; i<symbol; i++)
            System.out.println(i);
        
        System.out.print("Enter number of states: ");
        int state = s.nextInt();
        
        Node[] a = new Node[state];                                             //array of object initialization
        for(int y = 0; y < state; y++){
            a[y] = new Node();
            a[y].setID(y);                                                      //para ma identify yung node 
            a[y].next = new Node[symbol];                                       //pag setup ng array of object sa node
        }                                                                       //loop para malagyan ng laman ng object yung array
        System.out.println("Start State is q0");
        for(int c = 0; c<state; c++){
            for(int j = 0; j < symbol; j++){
                System.out.print("\tδ(q"+c+", "+j+") = ");
                char x;
                do{                                                             
                    x = l.nextLine().charAt(1);                                 //expected value is q#, kukunin lang nya yung 2nd letter
                }while(Character.getNumericValue(x) < symbol);                  //loop para hindi pwede yung lagpas na state number
                a[c].next[j] = a[Character.getNumericValue(x)];                 // q->next = next node 
            }
            if(c!=0){
                System.out.print("is q"+c+" a final state?[Y/N]: ");
                char choice;
                choice = l.nextLine().charAt(0);                                //1st char lang kukunin
                if(choice == 'Y' || choice == 'y'){
                    a[c].setFinal();                                            //check yung Node.java
                }
            }
        }
/*                         2nd part                                           */
        char again = 'y';
        do{
            System.out.print("Enter a string: ");
            String strings = l.nextLine();
            char[] cstr = strings.toCharArray();                                //convert strings to char array
            int len = strings.length();                                         //length ng string
            Node current = a[0];                                                //setup ng start node
            for(int q = 0; q < len; q++){                                       //condition sa pag basa ng string 
                int cti = Character.getNumericValue(cstr[q]);                   //convertion ng char to numeric value
                System.out.print("δ(q"+current.getID()+", "+cti+") = q"); 
                current = current.next[cti];                                    // q = q->next ng c
                System.out.println(current.getID());
            }
            if(current.isFinal() == true)
                System.out.println(strings + " is accepted!");
            else
                System.out.println(strings + " is rejected!");
            System.out.print("Enter another string?[Y/N]: ");
        }while( again == 'y' || again == 'Y');
    }
    
}