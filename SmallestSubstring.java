import java.util.Scanner;
public class SmallerSubstring {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        SmallerSubstring ss= new SmallerSubstring();
        System.out.println("Enter the string :");
        String inputFromUser=sc.next();
        System.out.println("Enter the smallest substring length : ");
        int k=sc.nextInt();
        String smallestString = ss.smallestSubString(inputFromUser,k);
        System.out.println("The smallest substring with the length "+k+" is "+ smallestString);

        String easyWyString = ss.easyWay(inputFromUser,k);
        System.out.println("The smallest substring with the length using easy way "+k+" is "+ easyWyString);
    }

    private String smallestSubString(String inputFromUser, int k) {
        if(inputFromUser.length()==0){
            return inputFromUser;
        }
        String ans="";
        int result=Integer.MAX_VALUE;
        for(int i=0;i<=inputFromUser.length()-k;i++){
            int x=0;
            for(int j=0;j<k;j++){
                x+=(int)inputFromUser.charAt(i+j);
                //System.out.println("the x value is : "+x);
            }
            if(x < result){
                result=x;
                ans=inputFromUser.substring(i, i+k);
            }
        }
        return ans;
    }
    private String easyWay(String inputFromUser, int k){
        int score=0 , n=inputFromUser.length();
        String ans=inputFromUser.substring(0, k);

        for(char ch:ans.toCharArray()){
            score+=ch;
        }
        int minScore=score;
        for(int i=k;i<=n-k;i++){
            score+=inputFromUser.charAt(i);
            score-=inputFromUser.charAt(i-k);

            if(score<minScore){
                minScore=score;
                ans=inputFromUser.substring(i-k+1, i+1);
            }
        }
        return ans;
    }
}
