package automataproject;
import java.util.Scanner;

public class AutomataProject {
   
    public static void main(String[] args) {
        
/*                        1st part                                            */
        Scanner s = new Scanner(System.in);
        Scanner l = new Scanner(System.in);
        int symbol = 0;
        System.out.print("Enter number of symbols: ");
        do{
            try{
                symbol = s.nextInt();
            }catch(NumberFormatException e){
                System.out.println("Not a valid number");
            }
        }while(symbol==0);
        for(int i = 0; i<symbol; i++)
            System.out.println(i);
        
        int state = 0;
        System.out.print("Enter number of states: ");
        do{
            try{
                state = s.nextInt();
            }catch(NumberFormatException e){
                System.out.println("Not a valid number");
            }
        }while(state==0);
        Node[] a = new Node[state];
        for(int y = 0; y < state; y++){
            a[y] = new Node();
            a[y].setID(y);
            a[y].next = new Node[symbol];
        }
        System.out.println("Start State is q0");
        for(int c = 0; c<state; c++){
            for(int j = 0; j < symbol; j++){
                int x = -1;
                do{ 
                    try{
                        System.out.print("\tδ(q"+c+", "+j+") = ");                                        
                        x = Integer.parseInt(l.nextLine().substring(1));
                    }catch(NumberFormatException e){
                        System.out.println("Invalid input.");
                    }
                }while(x<0);
                a[c].next[j] = a[x];
            }
            if(c!=0){
                char choice;
                do{
                System.out.print("is q"+c+" a final state?[Y/N]: ");
                choice = l.nextLine().charAt(0);
                }while(!(choice == 'y' || choice == 'Y' || choice == 'n' || choice == 'N'));
                if(choice == 'Y' || choice == 'y'){
                    a[c].setFinal();
                }
            }
        }
/*                         2nd part                                           */
        char again = 'y';
        do{
            System.out.print("Enter a string: ");
            String strings = l.nextLine();
            char[] cstr = strings.toCharArray();
            int len = strings.length();
            Node current = a[0];
            for(int q = 0; q < len; q++){
                int cti = Character.getNumericValue(cstr[q]);
                System.out.print("δ(q"+current.getID()+", "+cti+") = q"); 
                current = current.next[cti];
                System.out.println(current.getID());
            }
            if(current.isFinal() == true)
                System.out.println(strings + " is accepted!");
            else
                System.out.println(strings + " is rejected!");
            do{
            System.out.print("Enter another string?[Y/N]: ");
            again = l.nextLine().charAt(0);
            }while(!(again == 'y' || again == 'Y' || again == 'n' || again == 'N'));
        }while( again == 'y' || again == 'Y');
    }
}
