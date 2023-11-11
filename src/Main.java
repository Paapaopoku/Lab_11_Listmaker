import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static ArrayList<String> list = new ArrayList<>(); 

    public static void main(String[] args)
    {

       final String menu = "A - Add D - Delete P - Print Q - Quit";
       boolean done = false;
       String cmd = "";
        Scanner in = new Scanner(System.in);

       do {
           displayList();


           cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
           cmd = cmd.toUpperCase();

           switch (cmd)
           {
               case "A":
                   Add();
                   break;
               case "D":
                   Delete();
                   break;
               case "P":
                   break;
               case "Q":
                   if(SafeInput.getYNConfirm(in, "Are you sure you want to quit?"))
                   {
                       done = true;
                   }
                    break;
           }
                   System.out.println("cmd is " + cmd);  


           }
           while (!done) ;
       }

    private static void displayList()
    {
        System.out.println("---------------------------------------------");
        if(list.size() != 0)
        {

       for(int i = 0; i < list.size(); i++)
        {
            System.out.printf("%d. %s\n", i+1, list.get(i));
        }

        }
        else
            System.out.println(" ---      Nothing in the list      ---");
        System.out.println("---------------------------------------------");
    }

    private static void Add()
    {
        Scanner in = new Scanner(System.in);
        String item = SafeInput.getNonZeroLenString(in, "Enter the item you want to add");
        list.add(item);
    }

    private static void Delete()
    {
        Scanner in = new Scanner(System.in);
        int dItem = SafeInput.getRangedInt(in, "What item number do you want to delete?: ", 1, list.size());
        list.remove(dItem - 1);
    }
}